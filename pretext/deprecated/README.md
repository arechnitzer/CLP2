# CLP-2 PreTexT source files
* The text and problem sets were originally written as separate texts in latex.
* In order to provide a good online text we translated the latex into  [pretext](https://pretextbook.org/) xml.
* The resulting pretext sources compile into a combined text with exercises.

## Figure files
* In order to compile the pretext into both html and pdf, the figures have been saved as both svg and pdf.
* See the latex sources for information on how they were produced.

## Minimal PreTexT installation
* You do not need to install all of [PreTexT](https://pretextbook.org/) to build CLP-2.
* We include here the minimum necessary pretext XSL files needed.
* Minor changes have been made to allow for CLP styling - those changes are tagged in the source.
* In time those styling options will be absorbed into the standard PreTexT code base.

## Compilation instructions
* The pretext source files can be compiled into html and PDF.
* The user does not need to install pretext, but only the xsltproc command.
* xsltproc is a standard package in most Linux and OSX distributions. For Windows we recommend taking a look at the [PreTexT installation instructions](https://pretextbook.org/tools.html).

### Compiling to LaTeX and PDF
* Move into the directory containing `clp_2_ic.xml`
* Run the following command:
`xsltproc --xinclude ./xsl/makeit-latex.xsl clp_2_ic.xml`
* This command takes a few minutes to run.
* This will produce a (large) latex file `clp_2_ic.tex`
* Compile this with `pdflatex clp_2_ic.tex`
* This will also take a few minutes to run and you'll have to run it a few times to get all the internal references right.

### Compiling to HTML
* Move into the directory called `site` which contains a single file `RQS.css`
* We will build the website in this directory, which should then be uploaded to its final hosting location.
* Run the following command
`xsltproc --xinclude ../xsl/makeit-html.xsl ../clp_2_ic.xml`
* This will take a few minutes to run and produce a large number of html files.
* We still need to build all the tikz figures. To do so we run the pretext helper script `mbx`
* In the site directory, first create an `images` subdirectory.
* Then run `../script/mbx -v -c latex-image -f svg -d ./images ../clp_2_ic.xml`  - this needs `pdf2svg` installed
* This will take some time since there are many images to compile.
* Finally - copy the non-tikz figures into place by copying the `text/figs/*.svg` directory to `site/text/figs` and copying the `problems/figs/*.svg` directory to `site/problems/figs`and copying `misc/by-nc-sa.svg`  to `text/figs/by-nc-sa.svg`.
* Now the html is ready and you can upload the entire `site` directory to the webserver of your choice.
