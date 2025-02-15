/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package org.pentaho.di.core.plugins;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pentaho.di.core.Const;
import org.pentaho.di.core.exception.KettlePluginException;
import org.pentaho.di.core.gui.GUIOption;
import org.pentaho.di.core.util.Utils;

import static java.lang.System.getProperty;

/**
 * Plugins of this type can extend to capabilities of the PluginRegistry
 *
 * User: nbaker Date: 3/14/11
 */
@PluginMainClassType( PluginRegistryExtension.class )
@PluginExtraClassTypes( classTypes = { GUIOption.class } )
@PluginAnnotationType( RegistryPlugin.class )
public class PluginRegistryPluginType extends BasePluginType implements PluginTypeInterface {

  private static PluginRegistryPluginType INSTANCE = new PluginRegistryPluginType();

  public PluginRegistryPluginType() {
    super( RegistryPlugin.class, "Plugin Extensions", "Plugin Registry Extension Types" );
    populateFolders( "pluginRegistry" );
  }

  public static PluginRegistryPluginType getInstance() {
    return INSTANCE;
  }

  @Override
  protected String getXmlPluginFile() {
    // This property is set by the import-export.bat/sh command line script to disable this native resource file from
    // processing.
    if ( !Utils.isEmpty( getProperty( "pentaho.disable.karaf", "" ) ) ) {
      return "KettleFileDisabled.xmldisabledxyzabc";  //we return a file that does not exist to suppress exceptions.
    }
    return Const.XML_FILE_KETTLE_REGISTRY_EXTENSIONS;
  }

  @Override
  protected String getMainTag() {
    return "registry-extensions";
  }

  @Override
  protected String getSubTag() {
    return "registry-extension";
  }

  @Override
  protected String getPath() {
    return "./";
  }

  @Override
  protected boolean isReturn() {
    return true;
  }

  @Override
  protected void addExtraClasses( Map<Class<?>, String> classMap, Class<?> clazz, Annotation annotation ) {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  private static class NativePlugin {
    Class<?> clazz;
    String id, name, desc;

    public NativePlugin( Class<?> clazz, String id, String name, String desc ) {
      this.clazz = clazz;
      this.id = id;
      this.desc = desc;
    }
  }

  private static List<NativePlugin> natives = new ArrayList<NativePlugin>();

  public static void registerNative( Class<?> clazz, String id, String name, String desc ) {
    natives.add( new NativePlugin( clazz, id, name, desc ) );
  }

  @Override
  protected void registerXmlPlugins() throws KettlePluginException {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  protected String extractID( Annotation annotation ) {
    return ( (RegistryPlugin) annotation ).id();
  }

  @Override
  protected String extractName( Annotation annotation ) {
    return ( (RegistryPlugin) annotation ).name();
  }

  @Override
  protected String extractDesc( Annotation annotation ) {
    return ( (RegistryPlugin) annotation ).description();
  }

  @Override
  protected String extractCategory( Annotation annotation ) {
    return "";
  }

  @Override
  protected String extractImageFile( Annotation annotation ) {
    return "";
  }

  @Override
  protected boolean extractSeparateClassLoader( Annotation annotation ) {
    return false;
  }

  @Override
  protected String extractI18nPackageName( Annotation annotation ) {
    return null;
  }

  @Override
  protected String extractDocumentationUrl( Annotation annotation ) {
    return null;
  }

  @Override
  protected String extractCasesUrl( Annotation annotation ) {
    return null;
  }

  @Override
  protected String extractForumUrl( Annotation annotation ) {
    return null;
  }

  @Override
  protected String extractClassLoaderGroup( Annotation annotation ) {
    return ( (RegistryPlugin) annotation ).classLoaderGroup();
  }

  @Override
  protected String extractSuggestion( Annotation annotation ) {
    return null;
  }
}
