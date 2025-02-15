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


package org.pentaho.di.trans.steps.addxml;

import org.pentaho.di.core.injection.Injection;
import org.pentaho.di.core.row.ValueMeta;

/**
 * Describes a single field in an XML output file
 * 
 * @author Matt
 * @since 14-jan-2006
 * 
 */
public class XMLField implements Cloneable {

  @Injection( name = "OUTPUT_FIELD_NAME", group = "OUTPUT_FIELDS" )
  private String fieldName;

  @Injection( name = "OUTPUT_ELEMENT_NAME", group = "OUTPUT_FIELDS" )
  private String elementName;

  private int type;

  @Injection( name = "OUTPUT_FORMAT", group = "OUTPUT_FIELDS" )
  private String format;

  @Injection( name = "OUTPUT_LENGTH", group = "OUTPUT_FIELDS" )
  private int length;

  @Injection( name = "OUTPUT_PRECISION", group = "OUTPUT_FIELDS" )
  private int precision;

  @Injection( name = "OUTPUT_CURRENCY_SYMBOL", group = "OUTPUT_FIELDS" )
  private String currencySymbol;

  @Injection( name = "OUTPUT_DECIMAL_SYMBOL", group = "OUTPUT_FIELDS" )
  private String decimalSymbol;

  @Injection( name = "OUTPUT_GROUPING_SYMBOL", group = "OUTPUT_FIELDS" )
  private String groupingSymbol;

  @Injection( name = "OUTPUT_ATTRIBUTE", group = "OUTPUT_FIELDS" )
  private boolean attribute;

  @Injection( name = "OUTPUT_ATTRIBUTE_PARENT_NAME", group = "OUTPUT_FIELDS" )
  private String attributeParentName;

  @Injection( name = "OUTPUT_NULL_STRING", group = "OUTPUT_FIELDS" )
  private String nullString;

  public XMLField( String fieldName, String elementName, int type, String format, int length, int precision,
      String currencySymbol, String decimalSymbol, String groupSymbol, String nullString, boolean attribute,
      String attributeParentName ) {
    this.fieldName = fieldName;
    this.elementName = elementName;
    this.type = type;
    this.format = format;
    this.length = length;
    this.precision = precision;
    this.currencySymbol = currencySymbol;
    this.decimalSymbol = decimalSymbol;
    this.groupingSymbol = groupSymbol;
    this.nullString = nullString;
    this.attribute = attribute;
    this.attributeParentName = attributeParentName;
  }

  public XMLField() {
  }

  public int compare( Object obj ) {
    XMLField field = (XMLField) obj;

    return fieldName.compareTo( field.getFieldName() );
  }

  public boolean equal( Object obj ) {
    XMLField field = (XMLField) obj;

    return fieldName.equals( field.getFieldName() );
  }

  public Object clone() {
    try {
      Object retval = super.clone();
      return retval;
    } catch ( CloneNotSupportedException e ) {
      return null;
    }
  }

  public int getLength() {
    return length;
  }

  public void setLength( int length ) {
    this.length = length;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName( String fieldname ) {
    this.fieldName = fieldname;
  }

  public int getType() {
    return type;
  }

  public String getTypeDesc() {
    return ValueMeta.getTypeDesc( type );
  }

  public void setType( int type ) {
    this.type = type;
  }

  @Injection( name = "OUTPUT_TYPE", group = "OUTPUT_FIELDS" )
  public void setType( String typeDesc ) {
    this.type = ValueMeta.getType( typeDesc );
  }

  public String getFormat() {
    return format;
  }

  public void setFormat( String format ) {
    this.format = format;
  }

  public String getGroupingSymbol() {
    return groupingSymbol;
  }

  public void setGroupingSymbol( String group_symbol ) {
    this.groupingSymbol = group_symbol;
  }

  public String getDecimalSymbol() {
    return decimalSymbol;
  }

  public void setDecimalSymbol( String decimal_symbol ) {
    this.decimalSymbol = decimal_symbol;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  public void setCurrencySymbol( String currency_symbol ) {
    this.currencySymbol = currency_symbol;
  }

  public int getPrecision() {
    return precision;
  }

  public void setPrecision( int precision ) {
    this.precision = precision;
  }

  public String getNullString() {
    return nullString;
  }

  public void setNullString( String null_string ) {
    this.nullString = null_string;
  }

  public String toString() {
    return fieldName + ":" + getTypeDesc() + ":" + elementName;
  }

  /**
   * @return Returns the elementName.
   */
  public String getElementName() {
    return elementName;
  }

  /**
   * @param elementName
   *          The elementName to set.
   */
  public void setElementName( String elementName ) {
    this.elementName = elementName;
  }

  /**
   * @return true if the field should be encoded as attribute instead of a child node.
   */
  public boolean isAttribute() {
    return attribute;
  }

  /**
   * @param attribute
   *          set to true if the field should be encoded as attribute instead of a child node
   */
  public void setAttribute( boolean attribute ) {
    this.attribute = attribute;
  }

  /**
   * @return Returns the attributeParentName.
   */
  public String getAttributeParentName() {
    return attributeParentName;
  }

  /**
   * @param attributeParentName
   *          The attributeParentName to set.
   */
  public void setAttributeParentName( String attributeParentName ) {
    this.attributeParentName = attributeParentName;
  }
}
