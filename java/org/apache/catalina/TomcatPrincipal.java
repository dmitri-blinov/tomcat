/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.catalina;

import java.security.Principal;
import java.util.Enumeration;

import org.ietf.jgss.GSSCredential;

/**
 * Defines additional methods implemented by {@link Principal}s created by
 * Tomcat's standard {@link Realm} implementations.
 */
public interface TomcatPrincipal extends Principal {

    /**
     * @return The authenticated Principal to be exposed to applications.
     */
    Principal getUserPrincipal();

    /**
     * @return The user's delegated credentials.
     */
    GSSCredential getGssCredential();

    /**
     * Calls logout, if necessary, on any associated JAASLoginContext and/or
     * GSSContext. May in the future be extended to cover other logout
     * requirements.
     *
     * @throws Exception If something goes wrong with the logout. Uses Exception
     *                   to allow for future expansion of this method to cover
     *                   other logout mechanisms that might throw a different
     *                   exception to LoginContext
     */
    void logout() throws Exception;

    /**
     * Returns the value of the named attribute as an <code>Object</code>, or
     * <code>null</code> if no attribute of the given name exists, or if
     * <code>null</code> has been specified as the attribute's name.
     * <p>
     * Only the servlet container may set attributes to make available custom
     * information about a Principal or the user it represents.
     *
     * @param name a <code>String</code> specifying the name of the attribute
     * @return an <code>Object</code> containing the value of the attribute, or
     *         <code>null</code> if the attribute does not exist, or if
     *         <code>null</code> has been specified as the attribute's name
     */
    Object getAttribute(String name);

    /**
     * Returns an <code>Enumeration</code> containing the names of the
     * attributes available to this Principal. This method returns an empty
     * <code>Enumeration</code> if the Principal has no attributes available to
     * it.
     *
     * @return an <code>Enumeration</code> of strings containing the names of
     *         the Principal's attributes
     */
    Enumeration<String> getAttributeNames();
}
