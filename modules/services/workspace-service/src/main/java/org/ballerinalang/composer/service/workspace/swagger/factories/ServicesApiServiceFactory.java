/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ballerinalang.composer.service.workspace.swagger.factories;


import org.ballerinalang.composer.service.workspace.swagger.impl.ServicesApiServiceImpl;

/**
 * Service factory class which returns service implementation objects on demand.
 */
public class ServicesApiServiceFactory {
    private final static ServicesApiServiceImpl service = new ServicesApiServiceImpl();

    public static ServicesApiServiceImpl getServicesApi() {
        return service;
    }
}