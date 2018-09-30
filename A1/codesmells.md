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
*class WarehouseSimulation, line 66-78 and line 79-90.
* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:
The codes in line 66-78 and line 79-90 are nearly identical. They do almost the same thing.
[In your own words, explain how this particular code smells.]

### Solution:
Delete codes from line 79 to 90, and add condition in line 66-78. In line 66, change the "else if" 
condition to "(nextEvent.startsWith("Picker")) or (nextEvent.startsWith("Sequencer")). 
In line 71, change the "else if" condition to "(nextEvent.endsWith("marshaling")) or (nextEvent.endsWith("sequences")).
[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
==== End template ====

# List of code smells