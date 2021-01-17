<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Adress</title>
                <style type="text/css">
                    TABLE {
                    width: 600px;
                    border: 4px double black;
                    border-collapse: collapse;
                    }
                    TD, TH {
                    border: 1px solid black;
                    }
                </style>
            </head>
            <body>
                <div align="center">
                    <h2>List of houses</h2>
                    <table border="1" style="margin-top: 5px">
                        <thead style="background: #C0C0C0">
                            <tr>
                                <th>id</th>
                                <th>street_name</th>
                                <th>number</th>
                                <th>liter</th>
                                <th>korpus</th>
                            </tr>
                        </thead>
                        <xsl:for-each select="ArrayList/item">
                            <tr>
                                <td><xsl:value-of select="house_id"/></td>
                                <td><xsl:value-of select="street_id/name"/></td>
                                <td><xsl:value-of select="number"/></td>
                                <td><xsl:value-of select="liter"/></td>
                                <td><xsl:value-of select="korpus"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>