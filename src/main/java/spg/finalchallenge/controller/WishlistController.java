package spg.finalchallenge.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.entity.Wishlist;
import spg.finalchallenge.payload.Response;
import spg.finalchallenge.service.ProductService;
import spg.finalchallenge.service.WishlistService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private ProductService productService;


    @ApiOperation(value = "add new wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered wishlist", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/wishlist")
    public ResponseEntity<?> saveWishlist(@RequestBody Wishlist wishlist) {
        try {
            wishlistService.sumTotal(wishlist);
            //Limite máximo de 20 produtos
            if (wishlist.getProducts().size() <= 20) {

                wishlistService.quantity(wishlist);

                return new ResponseEntity<>(wishlistService.saveWishlist(wishlist), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    // Add um novo produto
    @ApiOperation(value = "add new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered wishlist", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/wishlist/{cpf}/{idProduct}")
    public ResponseEntity<?> addProductInWishlistClient(@PathVariable String cpf, @PathVariable long idProduct) {
        Wishlist checkCpfClient = wishlistService.findByClientCpf(cpf);
        if (checkCpfClient == null) {
            return new ResponseEntity<>(
                    new Response(false, "Cpf not found cpf: " + cpf),
                    HttpStatus.NOT_FOUND);
        } else {
            Product productResult = productService.getId(idProduct);
            if (productResult == null) {
                return new ResponseEntity<>(
                        new Response(false, "Product not found id: " + idProduct),
                        HttpStatus.NOT_FOUND);
            }
            List<Product> listProduct = checkCpfClient.getProducts();
            listProduct.add(productResult);
            checkCpfClient.setProducts(listProduct);

            wishlistService.sumTotal(checkCpfClient);

            if (checkCpfClient.getProducts().size() <= 20) {
                Wishlist newListProduct = wishlistService.saveWishlist(checkCpfClient);

                wishlistService.quantity(checkCpfClient);

                return new ResponseEntity<>(newListProduct, HttpStatus.OK);
            }
            return new ResponseEntity<>(new Response(false, "Maximum product limit " + checkCpfClient.getProducts().size()),
                    HttpStatus.CONFLICT);
        }
    }

    //    - Consultar se um determinado produto está na Wishlist do cliente;

    @ApiOperation(value = "Check if product exists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the product", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "Passenger not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/wishlist/{cpf}/{idProduct}")
    public ResponseEntity<?> checkExistProduct(@PathVariable String cpf, @PathVariable long idProduct) {
        try {
            Wishlist cpfClient = wishlistService.findByClientCpf(cpf);
            if (cpfClient == null) {
                return new ResponseEntity<>(
                        new Response(false, "Cpf not found cpf: " + cpfClient),
                        HttpStatus.NOT_FOUND);
            } else {
                List<Product> productResult = cpfClient.getProducts();
                for (Product prod : productResult) {
                    if (prod.getId().equals(idProduct)) {
                        return new ResponseEntity<>(prod, HttpStatus.OK);
                    }
                }
            }
            return new ResponseEntity<>(
                    new Response(false, "Cpf not found cpf: " + cpfClient),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //    Consultar todos os produtos da Wishlist da cliente;
    @ApiOperation(value = "Find a list of products by customer cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered wishlist", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/wishlist/{cpf}")
    public ResponseEntity<List<?>> listProducts(@PathVariable String cpf) {
        try {
            Wishlist CpfClient = wishlistService.findByClientCpf(cpf);
            if (CpfClient != null) {
                List<Product> listProducts = CpfClient.getProducts();
                return new ResponseEntity(listProducts, HttpStatus.OK);
            } else {
                return new ResponseEntity(
                        new Response(false, "Cpf not found cpf: " + CpfClient),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity(
                    new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    // Product not found
    // Request Errors
    //    Remover um produto da Wishlist da cliente;
    @ApiOperation(value = "Delete a product by idWishlist and idProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered wishlist", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PutMapping("/wishlist/{idWishlist}/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable long idWishlist, @PathVariable long idProduct) {
        try {
            Wishlist wishlist = wishlistService.findByIdWishlist(idWishlist);
            if (wishlist == null) {
                return new ResponseEntity<>(
                        new Response(false, "Wishlist not found id: " + idWishlist),
                        HttpStatus.NOT_FOUND);
            } else {
                List<Product> listProductsResult = wishlist.getProducts();
                for (Product product : listProductsResult) {
                    if (product.getId().equals(idProduct)) {
                        listProductsResult.remove(product);

                        wishlistService.subTotal(wishlist);

                        wishlist.setProducts(listProductsResult);

                        wishlistService.quantity(wishlist);

                        Wishlist newListProduct = wishlistService.saveWishlist(wishlist);
                        return new ResponseEntity<>(newListProduct, HttpStatus.OK);
                    }
                }
            }
            return new ResponseEntity<>(
                    new Response(false, "Product not found id: " + idProduct),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
