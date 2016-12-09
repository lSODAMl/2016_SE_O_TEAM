# O_TEAM - 2016 SE Markdown Project
## Command Line Interface(CLI)
손다열 - 21200376 이동영 - 21200512 이한성 - 21200610 조혜인 - 21300739


##Where to put md file.
* Highest diretory is root directory. In root directory, there is a md file named ‘a.md’<br> 
and a directory named ‘O_TEAM’. ‘a.md’ is a dummy file that is needed for testing <br>
(please don’t delete this file. Otherwise it will cause error while testing or <br>
it cannot cover many test cases we made.). <br>
In directory ‘O_TEAM’, there are files and directories called ‘build.xml’, ‘README.md’, <br>
‘lib’ ,‘src’. Actual md file that you will use to convert to html file should be <br>
located in this directory O_TEAM. So it should be like root/O_TEAM/example.md .

 
##Compile
1. Go to O_TEAM directory where build.xml, src and lib directory exists.
2. Type ant.
3. Go to 'jar' directory.
4. Enter command like,
    java -jar project.jar -i a.md(markdown file)
5. You can check jacoco result on index.html which is at 'report' directory.
6. Test classes are in 'test' directory which is at root directory.


##Syntax
* java -jar project.jar __-i__ [md file]
* java -jar project.jar __-i__ [md file]+ __-o__ [html fi,e]*
* java -jar project.jar __-i__ [md file]+ __-s__ [plain]*
* java -jar project.jar __-i__ [md file]+ __-o__ [html file]* __-s__ [plain]*



##Format
* __-i__ [md file]
  1. When user enter md file, please add '.md'

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
  1. When user enter html file, please add '.html'

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

* __-s__ [plain]*
  1. A user can enter zero or more style option.
  2. If user does not input style option, program applies plain(default) style

good use
```
-s  
-s plain
```

bad use
```
-s fan
-s se fighting
```




### Style
1. plain - default style




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
