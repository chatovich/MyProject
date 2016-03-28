<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/rooms">
        <table border="1">
            <tr><td>Position</td><td>Name</td><td>square</td><td>height</td><td>perimeter</td><td>volume</td>
                <td>squareOfConstruction</td><td>aperture</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/rooms/room">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/rooms/room/position">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/square">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/height">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/perimeter">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/volume">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/squareOfConstruction">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/aperture">
        <td>
        <tr>

        </tr>
        </td>
    </xsl:template>

    <xsl:template match="/rooms/room/aperture/typeOfAperture">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/aperture/width">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/rooms/room/aperture/height">
        <td><xsl:apply-templates/></td>
    </xsl:template>


</xsl:stylesheet>