###Jetpack Compose Article app


###Introduction


This app is an articles app that displays information about Android Jetpack Compose library.

The concepts covered in this app are:
- Simple UI layout in Compose
- Add Text and Image composables in a Column composable.

###Pre-requisites


- How to create and use composables.
- How to use Jetpack Compose Layouts such as Columns and Surface.
- How to use Jetpack Compose Text and Image.
- How to use Preview composable to display the result of the developed app.


### Creating a Compose project
Launch the IDE and select the `Empty Compose Activity` template in the new project panel. Give your project any name and hit next/finish.
![New Compose Project](/engineering-education/getting-started-with-jetpack-compose-in-android/new-compose-project.png)

### New-Project structure
Once build finishes, the `MainActivity` file opens up. This serves as the entry point for our Application.

#### Explaining the Autogenerated code
Before we proceed, it's good to understand the code that comes with the Compose template.

```Kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    // Composables are called here
                }
            }
        }
    }
}
```
The `MainActivity` class inherits from `ComponentActivity()` which is a building block for Jetpack Compose components. The `setContent` lambda determines what will be displayed on the screen at runtime. It makes use of the Material theme when calling Composable functions (discussed below).

### Composable function
A Composable function is a tool that transforms data into a UI hierarchy. It's just like a regular Kotlin function only that it is annotated with `@Composable` annotation. 

Syntax:
```Kotlin
@Composable
fun FunctionName(){
    
}
```
Example:
```kotlin
@Composable
fun JetPackComposeArticleApp() {
    // body
}
```
A Composable function can take parameters of any type if need be. Notice that the function's name starts with an uppercase letter. Otherwise, the IDE yells at you! raising a warning over the same. 

>NB: A composable function can not be called in a non composable function.
When working with composable functions that accept arguments, it is recommended to use named parameters strategy to let the compiler know which properties are being implemented since we may not use all available properties.

### Displaying Previews
Previews give the developer a clue on how to expect the app to look at runtime. In compose, a preview is created by annotating a composable function with `@Preview` annotation. You can have as many previews as you wish especially when you want to test different UI components in different composables at the same time.

### Creating Composable user interface elements
UI elements play a paramount role in an app. In most cases, users give their feedback based on how the UI looks like. Compose has different techniques for creating these elements more concisely.

#### Text
This is an inbuilt composable function that displays a string provided in its parameter.

```kotlin
@Composable
fun TextExample(){
    Text(text = "Hello Android")
}
```
Here we can set text properties such as `color`, `font style`, `fontsize`, `alignment` etc.
```kotlin
Text(text = "Hello Android", color = Color.Blue, textAlign = TextAlign.Center)
```


### Image
Images are one of the components that makes an app appealing. Compose uses the `Image` function and a `painter` (the actual image resource) to display an image.
```Kotlin
@Composable
fun ImageExample(){
    val painter = painterResource(R.drawable.your_drawable)
    Image(
    painter = painter,
    contentDescription = "image description")
}
```
A content description is optional but it's very important especially to visually impaired users. Similarly, we can style an image by providing parameters such as contentScale, modifier, etc. Click `Command (⌘) `+`P` to see all the possible parameters.


The textState variable is a remembered state, meaning that its value is maintained during [recomposition](#states-and-intelligent-recomposition). Without it, characters won't appear when typing.


### Modifier
A composable's appearance can be decorated using a property function known as a 'modifier'. Any inbuilt composable can be modified using a modifier. When using a series of modifiers, the results of the previous one become the input of the next one. For this reason, we should be very keen on the order of modifiers.

 Let's take an image for example.

```Kotlin
fun ModifiedImage{
    Image(
        painter = painterResource(R.drawable.your_drawable)
        modifier = Modifier
            .border(3.pd, color = Color.Cyan, shape = CircleShape)
            .padding(2.dp)
            .clip(shape = CircleShape)
    )
}
```
#### Reusing modifiers
A modifier can be applied to multiple elements for similar modifications. This can be achieved through;
#### i). Passing a modifier as a parameter in a Composable function
```kotlin
@Composable
fun Example(modifier: Modifier = Modifier){
    // multiple components can use `modifier` argument as their base Modifier
    Image(
        ...
        modifier = modifier
    )
    // a modifier can also be expanded
    Text(
        ...
        modifier = modifier.//a modifying property
    )
}
```
#### ii). Declaring a modifier variable
```kotlin
@Composable
fun Example(){
    val modifier: Modifier = Modifier
    // 
    Image(
        ...
        modifier = modifier
    )
}
```

### Reusing Composables
A high-order function that accepts a composable function as an argument can be used to reuse other composables. This helps to keep your code DRY.

Call our function and pass a composable in its lambda.
```Kotlin
@Composable
fun CallFun(){
    HighOrder{
        ReuseDemo()
    }
}
```
Create a high order function.
```Kotlin
@Composable
fun HighOrder(composeFun: @Composable () -> Unit){
}
```
Create a function to be reused.
```Kotlin
@Composable
fun ReuseDemo(){
}
```
You may have realized that Compose builds on this approach. For instance, a button accepts `onClick` lambda whose value is a function.

### Surfaces
A surface is a scope in which components lay on the screen.
```Kotlin
@Composable
fun SurfaceDemo(){
    Surface(color = Color.Blue){ // decorate a surface
        // call composable functions here
    }
}
```

### Compose Layouts
You may have noticed that when you use more than one UI composable, the elements are stack on each other! Compose layouts allows us to arrange components with respect to each other.

#### Row
A row lays items horizontally. The order of appearance of an item is determined by its position in the code block.
```Kotlin
@Composable
fun RowExample(){
    Row{
        Text(text = "Hello ")
        Text(text = " Jetpack ")
        Text(text = "Compose")
    }
}
```
#### Columns
A column arranges items vertically.
```Kotlin
@Composable
fun RowExample(){
    Column{
        Text(text = "Hello")
        Text(text = "Jetpack")
        Text(text = "Compose")
    }
}
// A layout is also a composable function, so, it can have a modifier that
// applies to all its children.
```
###Sources
*[Learn Jetpack Compose](https://developer.android.com/jetpack/compose/layouts)

###Credits
*[Inspiration for the structure of this README](https://github.com/MaurineM/jetpack-compose-article/blob/main/README.md)

###Getting Started

1. Download the code
2. Open the project in Android Studio
3. Run the app
