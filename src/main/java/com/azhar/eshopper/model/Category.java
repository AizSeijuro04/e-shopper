package com.azhar.eshopper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long cateId;

    @Column(name = "cate_name")
    @Size(max = 25, message = "Jumlah max karakter adalah 25")
    @NotBlank(message = "field harus diisi")
    private String cateName;

    public Category() {
    }

    public Category(Long cateId,
            @Size(max = 25, message = "Jumlah max karakter adalah 25") @NotBlank(message = "field harus diisi") String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}
