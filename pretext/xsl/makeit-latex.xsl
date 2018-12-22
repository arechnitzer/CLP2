<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">


<!-- use clp style files  -->
<!-- <xsl:import href="./pretext-latex-CLP.xsl" /> -->
<xsl:import href="/home/andrew/Projects/pretext/mathbook/xsl/latex/pretext-latex-CLP.xsl" />


<!-- set font size and page geometry  -->
<xsl:param name="latex.font.size" select="'12pt'" />
<xsl:param name="latex.geometry" select="'letterpaper,left=3cm,right=3cm,top=2.5cm,bottom=2cm'"/>


<!-- to get statements in text but keep hints/answers/solutions in back -->
<xsl:param name="exercise.divisional.hint" select="'no'" />
<xsl:param name="exercise.divisional.answer" select="'no'" />
<xsl:param name="exercise.divisional.solution" select="'no'" />



<xsl:template match="conceptual">
<p><alert>Exercises &#8212; Stage 1</alert></p>
</xsl:template>
<xsl:template match="procedural">
<p><alert>Exercises &#8212; Stage 2</alert></p>
</xsl:template>
<xsl:template match="application">
<p><alert>Exercises &#8212; Stage 3</alert></p>
</xsl:template>

<xsl:template match="fromexam">\textasteriskcentered</xsl:template>

<xsl:template match="sect"> <xsl:text>&#167;</xsl:text></xsl:template>


<!-- red text -->
<xsl:template match="textred">
	{\textcolor{red}{
            <xsl:apply-templates />
            }}
</xsl:template>
<!-- blue text -->
<xsl:template match="textblue">
	{\textcolor{blue}{
            <xsl:apply-templates />
            }}
</xsl:template>

</xsl:stylesheet>
