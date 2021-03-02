# MVC ARCH

As I consider, although it is a architecture for **WEB** usually, we can still use into our project.

Here is three main parts for MVC:

- View: display data, it should be GUI block for us
- Controller: connect View and Model
- Model: work on data process

<br>

## Main

<u>**Pls, write your idea, which class should be included which block.**</u>

For the VIEW part, we use Java SWING instead of front web.

- `GameEngne`

For CONTROLLER and MODEL, normally exists these folders:

- /controller: **<u>it collision with our View part</u>**
- /service : handle the logical, `Player`
- /dao : Data Access Object, <u>**we do not need this part**</u>
- /entity :  put JavaBean class, e.g. `Base` , `Sprite`, ...
- /utils : common tool class, **<u>unknown we need or not</u>**

<br>

**JavaBean** format:

a formal format for store data, it asks the Class is **public** and has default **constructor**, every property is **private** and includes their **getter** and **setter** method, for example:

```java
public Student {
	private String name;
	private Integer id;
	
    public Student() {
    }
    
    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
```



So, guys, everything I wrote is not very strict. IF you have a good idea, pls do not hesitate to modify and add!



