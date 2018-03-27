package com.nouhoun.springboot.jwt.integration.controller;

/**
 * All controllers in spring should extend this controller so as to have
 * centralize control for doing any sort of common functionality.
 * e.g. extracting data from post request body
 *
 * @author : Y Kamesh Rao
 */
public abstract class BaseController {
    protected static final String JSON_API_CONTENT_HEADER = "Content-type=application/json";


}
