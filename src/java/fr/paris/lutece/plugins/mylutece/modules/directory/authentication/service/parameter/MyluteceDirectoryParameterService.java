/*
 * Copyright (c) 2002-2012, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.mylutece.modules.directory.authentication.service.parameter;

import fr.paris.lutece.plugins.mylutece.modules.directory.authentication.business.parameter.MyluteceDirectoryParameterHome;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.ReferenceItem;

import org.apache.commons.lang.StringUtils;


/**
 *
 * MyluteceDirectoryParameterService
 *
 */
public class MyluteceDirectoryParameterService implements IMyluteceDirectoryParameterService
{
    public static final String BEAN_SERVICE = "mylutece-directory.myluteceDirectoryParameterService";

    // PARAMETERS
    private static final String PARAMETER_ENABLE_PASSWORD_ENCRYPTION = "enable_password_encryption";
    private static final String PARAMETER_ENCRYPTION_ALGORITHM = "encryption_algorithm";

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferenceItem findByKey( String strParameterKey, Plugin plugin )
    {
        return MyluteceDirectoryParameterHome.findByKey( strParameterKey, plugin );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update( ReferenceItem userParam, Plugin plugin )
    {
        if ( userParam != null )
        {
            MyluteceDirectoryParameterHome.update( userParam, plugin );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPasswordEncrypted( Plugin plugin )
    {
        boolean bIsPasswordEncrypted = false;
        ReferenceItem userParam = findByKey( PARAMETER_ENABLE_PASSWORD_ENCRYPTION, plugin );

        if ( ( userParam != null ) && userParam.isChecked(  ) )
        {
            bIsPasswordEncrypted = true;
        }

        return bIsPasswordEncrypted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEncryptionAlgorithm( Plugin plugin )
    {
        String strAlgorithm = StringUtils.EMPTY;
        ReferenceItem userParam = findByKey( PARAMETER_ENCRYPTION_ALGORITHM, plugin );

        if ( userParam != null )
        {
            strAlgorithm = userParam.getName(  );
        }

        return strAlgorithm;
    }
}