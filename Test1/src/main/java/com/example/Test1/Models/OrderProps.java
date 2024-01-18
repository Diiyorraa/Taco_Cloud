package com.example.Test1.Models;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "orderprops.prefix")
@Data
@Validated
public class OrderProps {

    @Min(value=5, message= "must be between 5 and 25")
    @Max(value=25, message = "must be between 5 and 25")
    private int pageSize = 20;
}

