# O_TEAM - 2016 SE Markdown Project
###### 손다열 - 21200376
###### 이동영 - 21200512
###### 이한성 - 21200610
###### 조혜인 - 21300739
=========================================

## Command Line Interface(CLI)
CLI get command from a user. 

###Style(option)
1. plain: plain style(default)
> empty(no command)

2. fancy: fancy style
> --fancy

3. slide: slide style
> --slide

###Rule
1. Filename
User just input filename except '.md' or '.html'. 
For example, If you want to convert a.md file to b.html file, you input like this
> a b

2. Order
User input information by ordering: mdfile -> htmlfile -> style(option)


###Usage
1. md file
User can input just md filename. In the case, html file name is same with md filename and style is plain
> md_file

2. md file | style
User can input md filename and choice style. In the case, html file name is same with md filename
> md_file --slide


3. md file | html file
User can input md filename and decide html file name. In the case, style is default(plain)
>  md_file html_file

4. md file | html file | option
User can input md filename , html file name and option
>  md_file html_file --fancy
 
###Release
```
s
s
s
s
```
