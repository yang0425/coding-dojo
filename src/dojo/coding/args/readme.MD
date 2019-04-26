[http://codingdojo.org/kata/Args/](http://codingdojo.org/kata/Args/)

>Schema:
>logging:l:bool,port:p:int,directory:d:string

## Happy Cases

```
command: ""
result: logging: false, port: 0, directory: 
```
```
command: -l
result: logging: true, port: 0, directory:
```
```
command: -p 8080
result: logging: false, port: 8080, directory: 
```
```
command: -p -1
result: logging: false, port: -1, directory: 
```
```
command: -d /usr/logs
result: logging: false, port: 0, directory: /usr/logs
```
```
command: -d /usr/logs -l -p 8080
result: logging: true, port: 8080, directory: /usr/logs
```

## Invalid Parameter Exception
```
command: -l a
result: InvalidParameterException -> the flag 'l' should not has any parameters after it.
```
```
command: -p
result: InvalidParameterException -> the flag 'p' should has a int parameter after it.
```
```
command: -p a
result: InvalidParameterException -> the flag 'p' should has a int parameter after it.
```
```
command: -d
result: InvalidParameterException -> the flag 'd' should has a string parameter after it.
```
## Invalid Flag Exception
```
command: -s
result: InvalidFlagException -> the flag 's' is not supported.
```
## Invalid Command Exception
```
command: l
result: InvalidCommandException -> command must start with -{flag}.
```


