<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
    <html>
      <head>
	<title>Bestellung</title>
      </head>
      <xsl:apply-templates select="bestellung"/>
    </html>
  </xsl:template>
  
  <xsl:template match="bestellung">
    <body>
       <h2>Enthält folgende Aufträge:</h2>
      <xsl:apply-templates select="auftrag"/>
    </body>
  </xsl:template>
  
  <xsl:template match="auftrag">
    <h3>Auftrag <xsl:value-of select="@nummer"></xsl:value-of></h3>
    <p>Liefertermin: <xsl:value-of select="@liefertermin"></xsl:value-of></p>
    <p>Positionen:  <ul><xsl:apply-templates select="position"/></ul></p>
  </xsl:template>
  
  <xsl:template match="position">
    <li>Artikel: <xsl:value-of select="artikelnummer"/> Menge: <xsl:value-of select="menge"/></li>
  </xsl:template>
  
</xsl:stylesheet>
  

