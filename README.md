# STITCH: STupendous ITerative Crochet Helper

## Crochet Basics and the Program's Purpose

### What is Crochet?

Crochet is the process of using yarn and a crochet hook (a specially shaped rod with a hook on the end) to create a kind of fabric by pulling loops of yarn through other loops of yarn. The way this fabric is created determines its shape and therefore allows it to be made into large variety of items. This program is specifically for Amigurumi, which is the process of using crochet to make 3D items (e.g. plushies).

### What are Crochet Patterns?

Crochet patterns are a set of instructions that crocheters use to make a specific item. Most crocheters find patterns online to help them make the items they want, but some make their own patterns. Making a pattern requires familiarity with techniques to make common shapes, as well as a decent understanding of the math/logical process that is behind creating good-looking shapes with crochet.

### What is the Purpose of This Program?

This program is designed to help crocheters make their own patterns. I have taken the implicit logic that is used to make crochet patterns and explicitly stated it as code so that my program can generate a crochet pattern based of the given specifications. While it cannot immediately make a pattern for a specific item (e.g. a sheep), it can make basic shapes that can be combined to make those items (e.g. a sphere for the body).

A secondary purpose of this program is to make *mathematically accurate* crochet patterns. For example, the current standard method for making a crochet sphere is technically to make a cone, followed by a cylinder, followed by another cone, and once stuffed these shapes end up looking pretty close to a sphere. This program uses math to make an actual sphere of any size (which is helpful as the standard method looks less like a sphere in larger sizes). My goal is to give this program the ability to generate a multitude of patterns for different mathematically accurate shapes.

### Other Crocheters Who Gave me Inspiration

I am NOT the first person to wanted to make mathematically accurate crochet sphere. MsPremiseConclusion is the one who gave me the idea via this article https://mspremiseconclusion.wordpress.com/2010/03/14/the-ideal-crochet-sphere/. The math I use in this program to make a sphere is entirely of her creation, however the code is all original. For shapes besides spheres, the math will be largely of my own design, as MsPremiseConclusion's method doesn't really work with other shapes.

### Glossary of Crochet Terms

- **Stitch:** a single unit of crochet that is repeated over and over again to make a crochet item. *Abbreviation: st*
- **Row:** one length of 2D crochet; these lengths are stacked on top of each other to make a flat shape (e.g. rectangles, triangles). One row is created by making a line of stitches in one direction, and the next row is created by making a line of stitches in the other direction.
- **Round:** one length of 3D crochet; these lengths are also stacked on top of each other, but they make 3D shapes (e.g. spheres). One round is created by making a circle of stitches, and the next round is created by making another circle directly on top of the previous, forming a tight spiral shape. *Abbreviation: rd*
- **Stitch Gauge:** for a given yarn and crochet hook size, a stitch gauge is the number of stitches per inch (or other measurement, but this program uses per one inch). The gauge can be a decimal, and it is encouraged to measure at least four inches and divide so that the gauge is more accurate.
- **Round Gauge:** for a given yarn and crochet hook size, a round gauge is the number of rounds per inch (other measurements can be used, but this program uses per one inch). The gauge can be a decimal, and it is encouraged to measure at least four inches and divide so that the gauge is more accurate.
- **Chain stitch:** the foundational crochet stitch; it serves as the foundation for a lot of crochet items, as it can be made with just a strand of yarn. *Abbreviation: ch*
- **"Worked into":** crochet is a process of pulling loops of yarn (aka stitches) through other loops of yarn (aka stitches). The stitch currently being made is "worked into" the previous stitch (i.e. the loop currently being made is worked into, aka pulled through, the previous loop). 
- **Magic loop:** a special technique used to start crochet that is done in the round; it ensures that the top of an item remains closed and doesn't form a hole.
- **Single crochet:** the most basic crochet stitch; it makes up most of the volume of Amigurumi crochet items, and must be worked into one stitch. *Abbreviation: sc*
- **Increase:** the stitch used to increase the size of an item; it increases the total stitches in a row or round by one, and must be worked into one stitch. *Abbreviation: inc*
- **Decrease:** the stitch used to decrease the size of an item: it decreases the total stitches in a row or round by one, and must be worked into two stitches. *Abbreviation: dec*

## How the Program Works

### Shapes it can Currently Make *Correctly*

*Assuming I remembered to update the readme after making changes*
- **Sphere:** creates a sphere. When prompted by the program, enter the diameter of your desired sphere in inches, your crochet stitch gauge, and your crochet round gauge, and it will generate a pattern that will allow you to make a sphere of that size.
- **Circle:** creates a circle. When prompted by the program, enter the diameter of your desired circle in inches, your crochet stitch gauge, and your crochet round gauge, and it will generate a pattern that will allow you to make a circle of that size.
- **Elongated sphere:** creates a sphere with a cylinder inserted in the middle, thus elongating the sphere. When the total length of the shape is similar to the diameter of the circle/width of the shape, the resulting object will be oval/ellipsoid like. When prompted by the program, enter your desired diameter/width and desired length in inches, as well as your crochet stitch gauge and crochet round gauge in stitches per inch, and it will generate a pattern that will allow you to make an elongated sphere with those dimensions.
- **Cone:** creates a cone. When prompted by the program, enter the diameter and length of your desired cone in inches, as well as your crochet stitch gauge and round gauge in stitches per inch, and it will generate a pattern that will allow you to make a cone with those dimensions.

*If you generate one of the above shapes, and notice that the pattern doesn't work in some way, please let me know!*

### Shapes it can Currently Make *Incorrectly*

*Assuming I remembered to update the readme after making changes*
-  None

### Math Behind Making A Sphere

A crochet sphere is made of rounds of crochet stacked on top of each other. To make a sphere of a certain size, we need the total number of stitches in each round. To find the total number of stitches in a round, we need to find the circumference of each round (i.e. the circumference of the cross-sections of the sphere at the heights corresponding to each round). To find those circumferences, we will work with a vertical cross-section of the sphere.
![](./app/src/main/java/com/kitrady/sphereMathReference.png)
Assume the center of the circular cross-section is split into 360 degrees, with the top of the sphere being 90 degrees and the right side being 0 degrees. The edge of the circle represents all the possible positions of a round, and each of these positions has a corresponding radius on the circle. The radius of the *circle* can be used to find the radius of a *round*, which can then be used to find the circumference of a round; phrased another way, the vertical radius of a sphere can be used to find the smaller horizontal radii that result from taking horizontal cross-sections of the sphere. So for a round whose position is determined by theta, its radius is given by the equation *radius of round = radius of sphere x cos(theta)*, and the circumference is given by *circumference of round = radius of round x 2pi*. To find the stitch totals for each round, we just need to express the circumference in units of stitches instead of traditional distance measurements. To do this, convert the radius of sphere from inches to stitches by multiplying the desired radius (in inches) by the stitch gauge (in stitches per inch), and use that number in the equations.

To find the theta associated with each round, we need to find out how tall a round is in terms of degrees. We can do this by multiplying the desired radius of the sphere (in inches) by the round gauge (in rounds per inch) to find the radius of the sphere in rounds. We can then take the radius times 2pi to find the circumference in rounds. Then divide 360 degrees by the circumference to find the degrees per one round.

### Math Behind Making Circle

A crochet circle is made up of a bunch of adjacent flat rounds, with each round essentially forming a circle around the previous round. To make a circle of a certain size, we need the stitch totals for each round, which is the same as the circumference of the circle associated with each round in stitches (i.e. the circumference of each of the nested circles in stitches). To find these circumferences, we will use concentric circles whose radii increase by the height of a round per each circle (i.e. start with a circle whose radius is the same length as the height of one round, then a circle whose radius is the same length as the height of two rounds, and so on). First, we need the height of a round expressed in units of stitch length, which can be found by dividing the overall radius in stitches by the overall radius in rounds. Then, for each circle, we will multiply its radius in round height by the conversion factor we just found to get its radius in stitch length. Finally, we will take this radius in stitch length times 2pi to get the circumference in stitch length, aka the stitch total for the current that round.

### Math Behind Making an Elongated Sphere

A crocheted elongated sphere is just a crochet sphere with a cylinder in the middle, which is created by making several rounds composed of all single crochets. To find the stitch totals for each round, take the stitch totals for a sphere and add some number of rounds whose stitch total is the maximum stitch total in the sphere. To find the proper number of additional rounds, subtract the diameter of the sphere in inches from the total desired length of the shape in inches to find the length of the cylinder section in inches. Take this length times the round gauge to find the length of the cylinder portion in rounds, which is the number of additional rounds that are needed. Putting these rounds in the middle of the sphere rounds creates an elongated sphere.

### Math Behind Making a Cone
A crochet cone is made up of rounds which increase their number of stitches by a constant amount. The stitch totals for each round is just the circumference of that circular layer in stitches, which can be found using the radius in stitches; the radius can be found by treating the cone as a right triangle, where one leg is the radius, the other is the length, and the hypotenuse is the number of rounds. Use the radius and length (both measured in rounds) to find the hypotenuse in rounds via the pythagorean theorem, then divide the radius measured in stitches by the hypotenuse in rounds to find the change of the radius in stitches per one round. Use this number to find the radius for each round and multiply by 2pi to find the circumference in stitches, aka the stitch total for that round.

### Formatting a Pattern From Stitch totals

When creating a crochet pattern, most people start with stitch totals for each round, then format the instructions based on those totals. To better understand the logic that goes into this formatting, here are some example stitch totals:
- Rd 1: 6 st
- Rd 2: 11 st
- Rd 3: 13 st
- Rd 4: 13 st
- Rd 5: 11 st
- Rd 6: 6 st

Here are the final formatted rounds:

- Rd 1: 6 sc in magic ring (6)
- Rd 2: 5 inc, 1 sc (11)
- Rd 3: (4 sc, 1 inc) x2, 1 sc (13)
- Rd 4: sc in each st in rd (13)
- Rd 5: (4 sc, 1 dec) x2, 1 sc (11)
- Rd 6: 5 dec, 1 sc (6)

And here is a walkthrough of how to format the rounds:

- For round 1, we start the crochet with 6 single crochet in a magic ring. -> Rd 1: 6 sc in magic ring (6)
- For round 2, we go from 6 stitches in the previous round to 11 stitches in this round, so we need 11 - 6 = 5 increases. Since increases are worked into one stitch, and there are 6 stitches in the previous round, there is one remaining stitch after the 5 increases, so we will do one single crochet. -> Rd 2: 5 inc, 1 sc (11)
- For round 3, we go from 11 stitches to 13, so we need 2 increases. Since increases add material to the crochet item, we want to distribute them evenly throughout the round, so that the item grows evenly on all sides. We are working into 11 stitches, so we need 9 single crochets in addition to the 2 increases. 9 divided by 2 is 4 (with a remainder of one), so each increase will be "paired" with 4 single crochets to distribute them evenly, and we will add the remaining single crochet on at the end. Crocheters are like programmers and don't like to repeat themselves, so we will write "x2" to indicate that the group of stitches is repeated twice. -> Rd 3: (4 sc, 1 inc) x2, 1 sc (13)
- For round 4, we have 13 stitches just like the last round, so we single crochet into every stitch. -> Rd 4: sc in each st in rd (13)
- For round 5, we go from 13 stitches to 11, so we need 2 decreases, and just like the increases, we want them to be evenly distributed. Since decreases are worked into 2 stitches, and we are working into 13 stitches, we need 13 - 2(2) = 9 single crochets. 9 single crochets divided by 2 decreases is 8 stitches (with a remainder of one), so each decrease will be paired with 4 singles crochets, and one single crochet will go at the end. -> Rd 5: (4 sc, 1 dec) x2, 1 sc (11)
- For round 6, we need to go from 11 stitches to 6, so we need 5 decreases. We are working into 11 stitches, so 11 - 5(2) = 1 single crochet, and this single crochet will go at the end. -> Rd 6: 5 dec, 1 sc (6)

In longer patterns, an alternate format may be used, which is explained below:

- Say the current round has 13 stitches, and the previous has 9, so 13 - 9 = 4 increases. The 9 stitches we are working into minus the 4 increases results in 5 single crochets, and 5 divided by 4 increases is one single crochet per increase (with a remainder of one). -> Rd n: (1 sc, 1 inc) x4, 1 sc (13)
- Say the next round has 16 stitches, so 16 - 13 = 3 increases. If we walk through the normal logic, we would end up with (3 sc, 1 inc) x3, 1 sc (16). However, if we follow this process for the whole pattern, the increases/decrease of each round will stack on top of the increases/decreases of every other round and creates "bubbles" in the item. To prevent this, each round should have its increases/decreases offset by half a "section" (the stitches that are repeated) from the previous round. To do this, we put half of a section at the beginning of the round, and the other half at the end. A section in this example is "3 sc, 1 inc", so the half that will go at the beginning of the round is "1 sc, 1 inc", and the half that will go at the end is "2 sc". The standard is to put the increase/decrease in the beginning half, and put any remainders from dividing an odd number at the end (plus any other remaining stitches from division in previous steps). -> Rd n+1: 1 sc, 1 inc (3 sc, 1 inc) x2, 3 sc (16)

## How the Code Works

### The Structure of the Code

**InputHandler**

*This is an interface that defines how all ShapeInputHandler classes should act; the ShapeInputHandlers are supposed to get and share the information from the user that is needed to make the given shape. Each ShapeInputHandler works as described below.*
- The constructor of the ShapeInputHandler uses scanner to get needed information from the user
- Ask for information about the size of the desired shape, as well as the users crochet stitch gauge in stitches per inch and their crochet round gauge in rounds per inch
- If the given inputs are not ints or doubles, prints a message correcting the user
- Process the given information to distill into the needed values
  - There is also an alternate constructor that gets the needed information as parameters
- In addition to the constructors, there is the interface defined method which is responsible for making a ShapeMaker of the proper type using the information stored in the ShapeInputHandler
- There are also getters for the purpose of testing

**ShapeMaker**

*This is an interface that defines how all ShapeMaker classes should act; the ShapeMakers are supposed to use the information from their respective ShapeInputHandlers to calculate the stitch totals for each round. The general behavior for ShapeMakers, along with specific behaviors for individual classes, are described below.*
- ShapeMaker
  - Constructor gets needed information from InputHandler and calculates and other values that are needed
  - Then generates stitch totals in the interface defined method by calculating them using the stored information
  - Shares the stitch totals via the interface defined getter method
  - Each class also has an overridden toString method for testing purposes
- SphereMaker
  - Generates stitch totals for the first half of the rounds (i.e. the rounds with increases) using the math described above in a loop
  - Loops over the angles for each round, starting with the round at the top of the sphere where theta equals 90 - degreesPerRound, and decreases theta by degreesPerRound every loop, with the loop ending when theta is less than zero
  - If the loop has ended, and the last value for theta that it used is more than half of degreesPerRound, there is a "missing" round that was "lost" by splitting the sphere in half, so adds another stitch total for a round exactly at zero degrees
  - Finally, since a sphere has identical hemisphere, it duplicates and reverses the current stitch totals to get the totals for the remaining rounds (excluding the possible "missing" round)
- CircleMaker
  - Generates stitch total by looping over a current radius that increases by the height of a round until the desired radius is reached
  - Uses the math described above to find the stitch total from the current radius
- ElongatedSphereMaker
  - Creates a SphereMaker object with the information stored in the class to generate stitch totals for a sphere
  - Find the maximum stitch total and its index
  - Inserts several more rounds with this maximum stitch total after the index
  - Number of additional rounds is determined using the math described above
- ConeMaker
  -  Generates stitch total by looping over a current radius that increases by a pre-determined amount (see the math described above for details) until the desired radius is reached
  - Uses the math described above to find the stitch total from the current radius

**RoundComponentMaker**

*The purpose of this class is to make many roundComponent objects that represent the "components" of each round (mainly the groups of stitches, but also other components, e.g. the round number) and store these components in nested lists (the inner layer of list containing components and representing a round, the outer layer containing lists of components and representing a full pattern)*
- Constructor gets stitchesPerRound from a shape maker
- Makes components for the first round, which will always use a magic loop and thus needs special components
- Makes components for the rounds with increases and the rounds with decreases
- To do this, creates a finalLargestIndex variable that is the index of the final largest round
- It uses the stitch totals up until and including this index to make the increase rounds, and the totals after the index to make the decrease rounds
- For the increase rounds...
  - it first adds the round number to the list of components
  - Then it uses the difference between the current and previous elements in the stitchesPerRound list to find the number of increases
  - It then checks a bunch of conditions to see what format the round needs
  - If there are no increases, then the round is all single crochets
  - Otherwise, divides the current stitch total by the number of increases to find the number of stitches in a "section" (i.e. the sum of the increase and the singles crochets paired with the increase), and subtracts two to find the number of single crochets in a "section"
  - Then checks if there were any stitches lost to truncation, and adds them to an extraStitches variable if so
  - If there are no single crochets in a section, then the round is either all increases, or several increases followed by some extra single crochets
  - If the number of single crochets was calculated to be negative, this means some stitches will have more than one increase (i.e. going from 6 to 13 stitches would mean 7 increases, 13 / 7 = 1, 1 - 2 = -1, and 7 increases is greater than the 6 stitches that are being worked into, so some stitches will have more than one increase worked into them)
    - To make these rounds, some stitches will have three single crochets worked into them, as opposed to the two single crochets that make up an increase
    - To calculate how many stitches will have three single crochets (aka special increase stitches), finds the difference between the current stitch total and twice the previous stitch total
    - To find the number of normal increases, finds the difference between the previous stitch total and the number of special increases
  - Otherwise, it checks if this round should be an alternate round
    - If the counter is even and the number of increases is greater than one, makes an alternate round
    - If the counter is even and the number of increases is one, makes an alternate round with a different format because there is only one increase
    - Otherwise, makes a normal round
  - Finally, it checks if there were any extra stitches and adds them onto the end if so
- The decrease rounds follow a similar logic, with the only difference being that it sometimes compares to the previous stitch total instead of the current because the previous round has more stitches when doing decrease rounds

RoundComponentAssembler

*The purpose of this class is to assemble the round components into a full pattern by turning them into strings*

- Gets the nested list of round components from RoundComponentMaker
- In the assemble method, for each round (aka list of components in the nested list) it creates a string builder to collect the pieces of the round as they are made
- For each component in the round (aside from the last), it checks several things
- First, it checks if the component is the round number, and adds it to the string builder if so
- After that, checks if the string builder is empty or if a round number was just added
- If the string builder is empty or round number just added, runs a switch statement on the type of the current component
  - If the component type is magic ring, all single crochets, all increase, or all decrease, those all have very simple string representations, so it adds the string representation with the given component count to the string builder
  - If the type is single crochet, adds the component count to the running total of single crochets (as there might be multiple groups of single crochets in a row that we want to condense into one group)
  - If the type is increase or decrease, checks if the previous type was a single crochet, and if so adds the string representation of the running single crochet total to the string builder, then the according string representation of the increase or decrease, and if the previous type wasn't a single crochet, adds a different string for the increase or decrease
  - If the type is a repeat single crochet, adds the component count to the possible repeat single crochets to save it for later
  - If the type is a repeat increase or decrease, nothing needs to happen
  - If the type is a repeat count, checks if the component count is one, and if so, treats the possible repeat single crochets and other repeat stitches as normal stitches, but if not, treats the repeat stitches as a repeat
  - If the type is a special increase, adds the needed string representation depending on the component count
- If round was not empty or round number was not just added, runs a different switch statement on the type of the current component
  - This switch statement is almost identical to the previous one, expect it removes some cases that aren't possible given the preconditions and changes the string representations to match the preconditions
- After looping through the all the components, checks if there are any single crochets remaining in the single crochet total, and adds them if so
- Then checks if the very last component is a stitch total, and adds it if so
- Then adds the string builder to the formatted pattern list, and repeats for the remaining rounds
- Also has get formatted pattern and print pattern methods

### How to Run the Program

At time of writing, the only way to run the program is to download the files through GitHub, and open them in a code editor. Next, run the main function, and give inputs and receive outputs via the console.
