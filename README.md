# Lighter
<img align="right" src="https://github.com/arrdem/lighter/raw/master/etc/lighter.jpg" width=300/>

**TL;DR** Code analysis based highlighting for Clojure.

This project is designed to provide highlighting for my
[stacks](https://github.com/arrdem/stacks) project at some point in
the future.

## Manifesto

Right now, there's a couple different tools that claim to do source
code highlighting for Clojure:

 - [pygments](https://pygments.org) is a tried and true framework for
   writing syntax highlighters.
 - [glow](https://github.com/venantius/glow) is a Clojure highlighter
   written in Clojure using a custom Antlr parser which strives to be
   general purpose.

as well as a couple JavaScript code highlighters which claim to
highlight Clojure correctly and the application-specific highlighters
embedded in every Clojure IDE (vim-clojure(-static), CIDER, Cursive
etc.).

Excepting Cursive's syntax highlighter which is based on Intellij's
code analysis capabilities, none of these tools really leverage
analysis information for highlighting and there certainly is not a
code highlighter I've been able to find which both is capable of
emitting HTML and which leverages analysis information.

Enter lighter.

What [microfiche](https://github.com/arrdem/microfiche) does for
Javadoc, Lighter aims to do for at least Clojure code.

Lighter is an application of [Nicola Mometto's](https://github.com/Bronsa)'s 
excellent clojure-in-clojure suite (tools.analyzer, tools.reader)
to extracting syntax information from read forms and generating 
highlighted code.

The goal of Lighter is to provide structural highlighting features
such as identifying locals and global vars along with formatting
information appropriate to generating at least HTML output if not ANSI
codes and other formats as well. By depending on the contrib
reader(s), Lighter can provide correctness properties which are
otherwise difficult to achieve for other highlighters.

## License

Copyright © 2017 Reid "arrdem" McKenzie

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
