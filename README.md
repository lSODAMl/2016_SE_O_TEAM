# O_TEAM - 2016 SE Markdown Project
## Command Line Interface(CLI)
손다열 - 21200376 이동영 - 21200512 이한성 - 21200610 조혜인 - 21300739


##Compile
1. Go to directory that Main.java file exist(root directory in this project)
2. Enter this command <br>
   * javac Main.java 
   * javac CLI/CLI.java 
   * javac CLI/CLI_Checker.java

##Syntax
* java Main __-i__ [md file]+
* java Main __-i__ [md file]+ __-o__ [html file]*
* java Main __-i__ [md file]+ __-s__ [plain | fancy | slide]*
* java Main __-i__ [md file]+ __-o__ [html file]* __-s__ [plain | fancy | slide]*




##Format
* __-i__ [md file]+
  1. A user can enter one or more md file/s.
  2. When user enter md file/s, please add '.md'

good use
```
-i markdown1.md
-i markdown1.md markdown2.md
```
bad use
```
-i markdown1
-i markdown1.m markdown2.se
```

* __-o__ [html file]*
  1. User can enter zero or mre html file.s.
  2. When user enter html file/s, please add '.html'

good use
```
-o html1.html
-o html1.html html2.html
```

bad use
```
-o html1.htm
-o html1.ht html2.se
```

* __-s__ [plain | fancy | slide]*
  1. A user can enter zero or more style option.
  2. If user does not input style option, program applies plain(default) style

good use
```
-s  
-s slide
-s fancy slide
```

bad use
```
-s fan
-s se fighting
```




### Style
1. plain - default style
2. fancy - fancy style
3. slide - slide style




### Exception issue
* Help message: -help
>If user enter '-help' in command line, he/she can see help message

* Normalization
>If user enter '\ / : ? < > |' in md file or html file name, program reject command.

* Check md file exist
>Program check md file is/are exist. So adjust dir in CLI.java -> CheckInputFile(method)-> directory(attribute) or check md file is existed

* Duplicated HTML file
>If HTML file already exists, program is numbering in HTML file. So adjust dir in CLI.java -> CheckOutputFile(method) -> directory(attribbute)
>ex) <br>
>* html.html<br>
>* html(1).html<br>
>* html(2).html

* Command line have to be received in-order.
1. HTML file number or style number do not exceed md file number
2. If user empty html file or style
  * html file name is same with md file name
  * style is plain(default style)
