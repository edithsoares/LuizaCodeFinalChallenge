package spg.finalchallenge.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @NotNull
    @Column(name = "nome")
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Column(name = "cpf")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull
    @Column(name = "address")
    @Size(min = 1, max = 100)
    private String address;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
