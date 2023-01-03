package com.prestashop.demo.frontend;

public interface Attributes {

    /**
     * Return true - if form exists, and false - if form does not exist
     *
     * @return true - if form exists, and false - if form does not exist
     */
    boolean isExist();

    String getName();
}
