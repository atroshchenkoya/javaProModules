package ru.otus.patterns1.dto;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String title;
    private final String description;
    private final double cost;
    private final double weight;
    private final double width;
    private final double length;
    private final double height;

    public double getWeight() {
        return weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Product(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.cost = builder.cost;
        this.weight = builder.weight;
        this.width = builder.width;
        this.length = builder.length;
        this.height = builder.height;
    }

    public static final class Builder {
        private UUID id;
        private String title;
        private String description;
        private double cost;
        private double weight;
        private double width;
        private double length;
        private double height;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder cost(double cost) {
            this.cost = cost;
            return this;
        }
        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }
        public Builder width(double width) {
            this.width = width;
            return this;
        }
        public Builder length(double length) {
            this.length = length;
            return this;
        }
        public Builder height(double height) {
            this.height = height;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }
}
