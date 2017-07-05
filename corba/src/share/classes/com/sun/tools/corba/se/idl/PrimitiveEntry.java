/*
 * Copyright 1999 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
/*
 * COMPONENT_NAME: idl.parser
 *
 * ORIGINS: 27
 *
 * Licensed Materials - Property of IBM
 * 5639-D57 (C) COPYRIGHT International Business Machines Corp. 1997, 1999
 * RMI-IIOP v1.0
 *
 */

package com.sun.tools.corba.se.idl;

// NOTES:

import java.io.PrintWriter;
import java.util.Hashtable;

/**
 * This is the symbol table entry for primitive types:  octet, char,
 * short, long, long long (and unsigned versions), float, double, string.
 **/
public class PrimitiveEntry extends SymtabEntry
{
  protected PrimitiveEntry ()
  {
    super ();
    repositoryID (Util.emptyID);
  } // ctor

  protected PrimitiveEntry (String name)
  {
    name (name);
    module ("");
    repositoryID (Util.emptyID);
  } // ctor

  protected PrimitiveEntry (PrimitiveEntry that)
  {
    super (that);
  } // ctor

  public Object clone ()
  {
    return new PrimitiveEntry (this);
  } // clone

  /** Invoke the primitive type generator.
      @param symbolTable the symbol table is a hash table whose key is
       a fully qualified type name and whose value is a SymtabEntry or
       a subclass of SymtabEntry.
      @param stream the stream to which the generator should sent its output.
      @see SymtabEntry */
  public void generate (Hashtable symbolTable, PrintWriter stream)
  {
    primitiveGen.generate (symbolTable, this, stream);
  } // generate

  /** Access the primitive type generator.
      @returns an object which implements the PrimitiveGen interface.
      @see PrimitiveGen */
  public Generator generator ()
  {
    return primitiveGen;
  } // generator

  static PrimitiveGen primitiveGen;
} // class PrimitiveEntry
