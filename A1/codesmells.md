# Markdown

Markdown is a plain-text file format. There are lots of programming tools that use Markdown, and it's useful and
easy to learn. Hash marks (the number sign) indicate headers. Asterisks indicate lists.

# Template

Use the following Code Smell template (copy and paste it at the end of this file and then edit it; don't include the "Begin template" or "End template" lines):

==== Begin template ====
## Code Smell: [Write the code smell name]
Dispensable
### Code Smell Category: [Write the code smell category name]
Duplicate Code
### List of classes and line numbers involved:
*class WarehouseManager, line 97-104, line 144-151.
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
The codes are nearly identical. They do almost the same thing.

[In your own words, explain how this particular code smells.]

### Solution:
Delete method pickerToMarshaling, and merge it with method addPicker.
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]

## Code Smell: [Write the code smell name]
Dispensable
### Code Smell Category: [Write the code smell category name]
Dead Code
### List of classes and line numbers involved:
*class OrderListManager, all lines
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
The codes in this class and even the class itself is no longer used.
[In your own words, explain how this particular code smells.]

### Solution:
Delete this class.
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]

## Code Smell: [Write the code smell name]
Dispensable
### Code Smell Category: [Write the code smell category name]
Lazy Class
### List of classes and line numbers involved:
*class Worker
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
Class Worker does not contain anything inside. And it is never used.
[In your own words, explain how this particular code smells.]

### Solution:
Delete this class.
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]

## Code Smell: [Write the code smell name]
Bloaters
### Code Smell Category: [Write the code smell category name]
Long Method
### List of classes and line numbers involved:
*class WarehouseSimulation, line 42-97.
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
Method "start" is much longer than 15 lines of actual code.
[In your own words, explain how this particular code smells.]

### Solution:
There is duplicate Code from line 66-90, delete codes from line 79 to 90, and add condition in line 66-78. In line 66, 
change the "else if" condition to "(nextEvent.startsWith("Picker")) or (nextEvent.startsWith("Sequencer")). In line 71, 
change the "else if" condition to "(nextEvent.endsWith("marshaling")) or (nextEvent.endsWith("sequences")).
Also, use inheritance. Use subclasses which inheritance the class WarehouseSimulation. For example, use "class 
OrderNextEvent extends WarehouseSimulation" to replace if statement "nextEvent.startsWith("Order")" and use "class 
PickerSequencerNextEvent extends WarehouseSimulation" to replace else if statement "nextEvent.startsWith("Picker") or 
nextEvent.startsWith("Sequencer")".
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
==== End template ====

## Code Smell: [Write the code smell name]
Object-Orientation Abusers
### Code Smell Category: [Write the code smell category name]
Alternative Classes with Different Interfaces
### List of classes and line numbers involved:
*class PickerOrderList
*class SequencerOrderList
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
Class PickerOrderList and class SequencerOrderList use similar methods and do quite similar functionality.
For example, the method "getIDs" in both classes do almost the same thing except class PickerOrderList use 
pickerSKUOrder while class SequencerOrderList use sequencerSKUOrder. 
[In your own words, explain how this particular code smells.]

### Solution:
Write a superclass OrderList, let class PickerOrderList and class SequencerOrderList extends OrderList, write 
methods toString() and getIDs() in superclass OrderList.
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
# List of code smells
Dispensable: Duplicate Code, Dead Code, Lazy Class
Object-Orientation Abusers: Alternative Classes with Different Interfaces
Bloaters: Long Method
