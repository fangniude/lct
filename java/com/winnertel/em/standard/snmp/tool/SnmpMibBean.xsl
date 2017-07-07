<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="text"/>

    <xsl:template match="SnmpMibBean">
        <!-- Start file document, package declaration, imports -->
<xsl:text>/*

 */
package </xsl:text><xsl:value-of select="@package"/><xsl:text>;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;

</xsl:text>
        <xsl:apply-templates select="OperationList" mode="import"/>
        <xsl:apply-templates select="MibItemList" mode="import"/>
        <!-- End file document, package declaration, imports -->

        <!-- Start class document -->
<xsl:text>
/**
 * The </xsl:text><xsl:value-of select="@class"/><xsl:text> class.
 *
 */
</xsl:text>
        <!-- End class document -->

        <!-- Start class declaration -->
        <xsl:text>public class </xsl:text><xsl:value-of select="@class"/><xsl:text> extends SnmpMibBean {
</xsl:text>
        <!-- End class declaration -->

        <!-- Start property names -->
        <xsl:apply-templates select="MibTableList" mode="initPropertyName"/>
        <!-- End property names -->

        <!-- Start mib table oids -->
<xsl:text>
</xsl:text>
        <xsl:apply-templates select="MibTableList" mode="initMibTableOid"/>
        <!-- End mib table oids -->

        <!-- Start constructor -->
<xsl:text>

    public  </xsl:text><xsl:value-of select="@class"/><xsl:text>(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }
</xsl:text>
        <!-- End constructor -->

        <!-- Start init() -->
<xsl:text>

    protected void init() {
</xsl:text>
        <xsl:apply-templates select="MibTableList" mode="initProperty"/>
<xsl:text>    }


</xsl:text>
        <!-- End init() -->

        <!-- Start getter/setter method -->
        <xsl:apply-templates select="MibTableList" mode="propertyMethod"/>
        <!-- End getter/setter method -->

        <!-- Start operation method -->
        <xsl:apply-templates select="//Operation" mode="retrieve"/>
        <xsl:apply-templates select="//Operation" mode="retrieveAll"/>
        <xsl:apply-templates select="//Operation" mode="save"/>
        <!-- End operation method -->

<xsl:text>}
</xsl:text>

    </xsl:template>

    <xsl:template match="OperationList" mode="import">
        <xsl:for-each select="Operation">
            <xsl:if test="@name='retrieveAll'">
                <xsl:text>import java.util.Vector;
 </xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibTableList" mode="initPropertyName">
        <xsl:for-each select="//MibItem">
            <xsl:if test="string-length(@oid)>0 and @name!='rowStatus'">
                <xsl:text>    private final String </xsl:text><xsl:value-of select="@name"/><xsl:text> = "</xsl:text><xsl:value-of
                    select="@name"/><xsl:text>";
</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibTableList" mode="initMibTableOid">
        <xsl:for-each select="//MibTable">
            <xsl:text>    private final String f</xsl:text><xsl:value-of select="@name"/><xsl:text>TableOid = ".</xsl:text><xsl:value-of
                select="@oid"/><xsl:text>";
</xsl:text>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibTableList" mode="initProperty">
        <xsl:for-each select="//MibItem">
            <xsl:if test="@oid!=''">
                <xsl:text>        initProperty(</xsl:text>
                <xsl:apply-templates select="." mode="propertyName"/>
                <xsl:text>, new SnmpMibBeanProperty(</xsl:text>
                <xsl:apply-templates select="." mode="propertyName"/>
                <xsl:text>, f</xsl:text><xsl:value-of select="../../@name"/><xsl:text>TableOid + ".</xsl:text><xsl:value-of
                    select="@oid"/><xsl:text>", </xsl:text>
                <xsl:apply-templates select="." mode="propertyType"/>
            <xsl:text>));
</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibTableList" mode="propertyMethod">
        <xsl:for-each select="//MibItem">
            <xsl:variable name="itemName" select="@name"></xsl:variable>
            <xsl:variable name="itemIndex" select="@index"></xsl:variable>
            <xsl:variable name="firstChar"
                          select="translate(substring($itemName, 1, 1), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')"></xsl:variable>
            <xsl:variable name="otherChars" select="substring($itemName, 2, string-length($itemName)-1)"/>
            <xsl:variable name="propertyName" select="concat($firstChar, $otherChars)"/>
            <xsl:variable name="paraName" select="concat('a', $firstChar, $otherChars)"></xsl:variable>
            <xsl:if test="$itemName!='rowStatus'">
                <xsl:text>    public void set</xsl:text><xsl:value-of select="$propertyName"/><xsl:text>(</xsl:text>
                <xsl:apply-templates select="." mode="javaType"/>
                <xsl:text> </xsl:text><xsl:value-of select="$paraName"/><xsl:text>) {
</xsl:text>
                <xsl:choose>
                    <xsl:when test="@index!=''">
                        <xsl:text>        setIndex(</xsl:text><xsl:value-of select="$itemIndex"/><xsl:text>, </xsl:text><xsl:value-of
                            select="$paraName"/><xsl:text>);</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>        getProperty(</xsl:text><xsl:value-of select="$itemName"/><xsl:text>).setValue(</xsl:text><xsl:value-of
                            select="$paraName"/><xsl:text>);</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>
    }

</xsl:text>
                <xsl:text>    public </xsl:text>
                <xsl:apply-templates select="." mode="javaType"/>
                get<xsl:value-of select="$propertyName"/><xsl:text>() {
</xsl:text>
                <xsl:choose>
                    <xsl:when test="@index!=''">
                        <xsl:text>        return (</xsl:text>
                        <xsl:apply-templates select="." mode="javaType"/>
                        <xsl:text>) getIndex(</xsl:text><xsl:value-of select="$itemIndex"/><xsl:text>);</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>        return (</xsl:text>
                        <xsl:apply-templates select="." mode="javaType"/>
                        <xsl:text>) getProperty(</xsl:text><xsl:value-of select="$itemName"/><xsl:text>).getValue();</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>
    }


</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibItemList" mode="import">
        <xsl:for-each select="MibItem">
            <xsl:if test="@type='Counter64'">
                <xsl:text>import java.math.BigInteger;
</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="MibItem" mode="propertyName">
        <xsl:choose>
            <xsl:when test="@name!='rowStatus'">
                <xsl:value-of select="@name"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>ROW_STATUS</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="MibItem" mode="propertyType">
        <xsl:choose>
            <xsl:when test="@type='Integer'">
                <xsl:text>ISnmpConstant.INTEGER</xsl:text>
            </xsl:when>
            <xsl:when test="@type='IpAddress'">
                <xsl:text>ISnmpConstant.IP_ADDRESS</xsl:text>
            </xsl:when>
            <xsl:when test="@type='String'">
                <xsl:text>ISnmpConstant.STRING</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Counter'">
                <xsl:text>ISnmpConstant.COUNTER</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Gauge'">
                <xsl:text>ISnmpConstant.GAUGE</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Timeticks'">
                <xsl:text>ISnmpConstant.TIME_TICKS</xsl:text>
            </xsl:when>
            <xsl:when test="@type='MacAddress'">
                <xsl:text>ISnmpConstant.MAC_ADDRESS</xsl:text>
            </xsl:when>
            <xsl:when test="@type='ObjectId'">
                <xsl:text>ISnmpConstant.OBJID</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Counter64'">
                <xsl:text>ISnmpConstant.COUNTER64</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Octets'">
                <xsl:text>ISnmpConstant.OCTETS</xsl:text>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="MibItem" mode="javaType">
        <xsl:choose>
            <xsl:when test="@type='Integer'">
                <xsl:text>Integer</xsl:text>
            </xsl:when>
            <xsl:when test="@type='IpAddress'">
                <xsl:text>String</xsl:text>
            </xsl:when>
            <xsl:when test="@type='String'">
                <xsl:text>String</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Counter'">
                <xsl:text>Long</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Counter64'">
                <xsl:text>BigInteger</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Gauge'">
                <xsl:text>Long</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Timeticks'">
                <xsl:text>Long</xsl:text>
            </xsl:when>
            <xsl:when test="@type='MacAddress'">
                <xsl:text>byte[]</xsl:text>
            </xsl:when>
            <xsl:when test="@type='ObjectId'">
                <xsl:text>String</xsl:text>
            </xsl:when>
            <xsl:when test="@type='Octets'">
                <xsl:text>byte[]</xsl:text>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="MibItem" mode="indexByteCount">
        <xsl:choose>
            <xsl:when test="@type='Integer'">
                <xsl:text>1</xsl:text>
            </xsl:when>
            <xsl:when test="@type='IpAddress'">
                <xsl:text>4</xsl:text>
            </xsl:when>
            <xsl:when test="@type='MacAddress'">
                <xsl:text>6</xsl:text>
            </xsl:when>
            <xsl:when test="@type='String'">
                <xsl:text>32</xsl:text>
            </xsl:when>
            <xsl:when test="@type='ObjectId'">
                <xsl:text>0</xsl:text>
            </xsl:when>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="Operation" mode="retrieve">
        <xsl:if test="@name='retrieve'">
            <xsl:text>    public boolean </xsl:text><xsl:value-of select="@name"/><xsl:text>() throws MibBeanException {
</xsl:text>

            <xsl:for-each select="MibItemRef">
                <xsl:text>        prepareRead(getProperty(</xsl:text><xsl:value-of select="@name"/><xsl:text>));
</xsl:text>
            </xsl:for-each>

            <xsl:text>
        return load();
    }

</xsl:text>
        </xsl:if>
    </xsl:template>

    <xsl:template match="Operation" mode="retrieveAll">
        <xsl:if test="@name='retrieveAll'">
            <xsl:text>    public Vector </xsl:text><xsl:value-of select="@name"/><xsl:text>() throws MibBeanException {
</xsl:text>

            <xsl:for-each select="MibItemRef">
                <xsl:text>        prepareRead(getProperty(</xsl:text><xsl:value-of select="@name"/><xsl:text>));
</xsl:text>
            </xsl:for-each>

            <xsl:text>
        return loadAll(new int[]{</xsl:text>
            <xsl:for-each select="//MibItem">
                <xsl:if test="string-length(@index)>0">
                    <xsl:apply-templates select="." mode="indexByteCount"/>
                    <xsl:text>, </xsl:text>
                </xsl:if>
            </xsl:for-each><xsl:text>});
    }

</xsl:text>
        </xsl:if>
    </xsl:template>

    <xsl:template match="Operation" mode="save">
        <xsl:if test="@name='add' or @name='modify' or @name='delete'">
            <xsl:text>    public boolean </xsl:text><xsl:value-of select="@name"/><xsl:text>() throws MibBeanException {
</xsl:text>
            <xsl:if test="@row_status!=''">
                <xsl:text>        setRowStatus(new Integer(</xsl:text><xsl:value-of select="@row_status"/><xsl:text>));

        prepareSave(getProperty(ROW_STATUS));
</xsl:text>

            </xsl:if>

            <xsl:for-each select="MibItemRef">
                <xsl:text>        prepareSave(getProperty(</xsl:text><xsl:value-of select="@name"/><xsl:text>));
</xsl:text>
            </xsl:for-each>

            <xsl:text>
        return save();
    }

</xsl:text>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>
