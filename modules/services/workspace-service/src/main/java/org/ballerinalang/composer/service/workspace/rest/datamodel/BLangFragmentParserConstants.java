/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.composer.service.workspace.rest.datamodel;

/**
 * Constants related to fragment parser
 */
public class BLangFragmentParserConstants {
    // expected node types
    public static final String STATEMENT = "statement";
    public static final String EXPRESSION = "expression";
    public static final String JOIN_CONDITION = "join-condition";
    public static final String ARGUMENT_PARAMETER = "argument_parameter_definitions";
    public static final String RETURN_PARAMETER = "return_parameter_definitions";
    public static final String TRANSACTION_FAILED = "transaction_failed";
    public static final String VARIABLE_REFERENCE_LIST = "variable_reference_list";

    // wrapper templates
    protected static final String FUNCTION_BODY_STMT_WRAPPER = "function testFunction(){\n$FRAGMENT\n}";
    protected static final String VAR_DEF_STMT_EXPR_WRAPPER = "function testFunction(){any val =\n$FRAGMENT;\n}";
    protected static final String FORK_JOIN_CONDITION_WRAPPER =
            "function testFunction(){fork{}join($FRAGMENT)(map param){}}";
    protected static final String FRAGMENT_PLACE_HOLDER = "$FRAGMENT";
    protected static final String FUNCTION_SIGNATURE_PARAMETER_WRAPPER = "function testFunction($FRAGMENT){\n}";
    protected static final String FUNCTION_SIGNATURE_RETURN_WRAPPER = "function testFunction()($FRAGMENT){\n}";
    protected static final String TRANSACTION_FAILED_RETRY_WRAPPER =
            "function testFunction(){transaction{}failed{$FRAGMENT}aborted{}committed{}}";
    protected static final String VAR_REFERENCE_LIST_WRAPPER =
            "function testFunction(){\n$FRAGMENT=testFunction();\n}";
}
