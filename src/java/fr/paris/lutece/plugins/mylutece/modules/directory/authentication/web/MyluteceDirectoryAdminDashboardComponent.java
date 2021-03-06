/*
 * Copyright (c) 2002-2017, Mairie de Paris
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
package fr.paris.lutece.plugins.mylutece.modules.directory.authentication.web;

import fr.paris.lutece.plugins.mylutece.modules.directory.authentication.service.IMyluteceDirectoryService;
import fr.paris.lutece.plugins.mylutece.modules.directory.authentication.service.MyluteceDirectoryResourceIdService;
import fr.paris.lutece.plugins.mylutece.modules.directory.authentication.service.MyluteceDirectoryService;
import fr.paris.lutece.portal.business.rbac.RBAC;
import fr.paris.lutece.portal.business.user.AdminUser;
import fr.paris.lutece.portal.service.dashboard.admin.AdminDashboardComponent;
import fr.paris.lutece.portal.service.rbac.RBACService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.util.html.HtmlTemplate;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 *
 * MyluteceDirectoryAdminDashboardComponent
 *
 */
public class MyluteceDirectoryAdminDashboardComponent extends AdminDashboardComponent
{
    // CONSTANTS
    private static final String EMPTY_STRING = "";

    // TEMPLATES
    private static final String TEMPLATE_ADMIN_DASHBOARD = "admin/plugins/mylutece/modules/directory/directory_admindashboard.html";

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String getDashboardData( AdminUser user, HttpServletRequest request )
    {
        if ( RBACService.isAuthorized( MyluteceDirectoryResourceIdService.RESOURCE_TYPE, RBAC.WILDCARD_RESOURCES_ID,
                    MyluteceDirectoryResourceIdService.PERMISSION_MANAGE, user ) )
        {
            IMyluteceDirectoryService service = SpringContextService.getBean( MyluteceDirectoryService.BEAN_SERVICE );
            Map<String, Object> model = service.getManageAdvancedParameters( user );
            HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_ADMIN_DASHBOARD, user.getLocale(  ), model );

            return template.getHtml(  );
        }

        return EMPTY_STRING;
    }
}
