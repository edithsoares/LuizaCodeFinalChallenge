package spg.finalchallenge.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.payload.Response;
import spg.finalchallenge.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Save a new Product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the registered product", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 400, message = "Bad request", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>( new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Search all products")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Returns the list of products", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "List products not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @GetMapping("/products")
    public ResponseEntity<?> listAllProducts(){
        try {
            List<Product> products = productService.listAllProduct();
            if (products != null){
                return new ResponseEntity<>(products, HttpStatus.OK);
            }else {
                return new ResponseEntity(new Response(false, "Product not found"),
                        HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>( new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update product")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Returns the list of products", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "List products not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @PutMapping("/product/update/{id}")
    public ResponseEntity<?> updateProduto(@RequestBody Product produto, @PathVariable(value = "id") long id) {
       try {
           Optional<Product> prod = productService.findById(id);
           if(prod.isPresent()){
               produto.setId(prod.get().getId());
               return new ResponseEntity<>(productService.update(produto), HttpStatus.OK);
           }
           return new ResponseEntity(new spg.finalchallenge.payload.Response(false, "Product not found"),
                HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new ResponseEntity<>( new Response(false, "Request Errors"),
                HttpStatus.BAD_REQUEST);
       }
    }

    @ApiOperation(value = "Delete products")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Returns the id deleted", response = Response.class),
            @ApiResponse(code = 401, message = "You do not have permission to access this feature.", response = Response.class),
            @ApiResponse(code = 404, message = "List products not found", response = Response.class),
            @ApiResponse(code = 500, message = "An exception was thrown", response = Response.class),
    })
    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<?> deleteProductByCpf(@PathVariable long id){
        try {
            Product productResult = productService.getId(id);
            if (productResult != null){
                productService.deleteProduct(productResult);
                return new ResponseEntity<>(new Response(true, "Product deleted id: " + id ),
                        HttpStatus.OK);
            }else {
                return new ResponseEntity(new Response(false, "Product not found"),
                        HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>( new Response(false, "Request Errors"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
