package fr.paris.lutece.plugins.mylutece.modules.directory.authentication.service;

import fr.paris.lutece.plugins.mylutece.service.AbstractAnonymizationDaemon;
import fr.paris.lutece.plugins.mylutece.service.IAnonymizationService;
import fr.paris.lutece.portal.service.spring.SpringContextService;


/**
 * User anonymization daemon
 * 
 */
public class MyluteceDirectoryAnonymizationDaemon extends AbstractAnonymizationDaemon
{
    MyluteceDirectoryAnonymizationService _anonymizationService = SpringContextService
            .<MyluteceDirectoryAnonymizationService> getBean( MyluteceDirectoryAnonymizationService.BEAN_SERVICE );

    /**
     * Default constructor
     */
    public MyluteceDirectoryAnonymizationDaemon( )
    {
        super( );
        setPluginName( MyluteceDirectoryPlugin.PLUGIN_NAME );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IAnonymizationService getAnonymizationService( )
    {
        return _anonymizationService;
    }

}