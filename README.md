# crochet-pattern-maker

## Crochet Basics and the Program's Purpose

### What is Crochet?

Crochet is the process of using yarn and a crochet hook (a specially shaped rod with a hook on the end) to create a kind of fabric by pulling loops of yarn through other loops of yarn. The way this fabric is created determines its shape and therefore allows it to be made into large variety of items. This program is specifically for Amigurumi, which is the process of using crochet to make 3D items (e.g. plushies).

### What are Crochet Patterns?

Crochet patterns are a set of instructions that crocheters use to make a specific item. Most crocheters find patterns online to help them make the items they want, but some make their own patterns. Making a pattern requires familiarity with techniques to make common shapes, as well as a decent understanding of the math/logical process that is behind creating good-looking shapes with crochet.

### What is the Purpose of This Program?

This program is designed to help crocheters make their own patterns. I have taken the implicit logic that is used to make crochet patterns and explicitly stated it as code so that my program can generate a crochet pattern based of the given specifications. While it cannot immediately make a pattern for a specific item (e.g. a sheep), it can make basic shapes that can be combined to make those items (e.g. a sphere for the body).

A secondary purpose of this program is to make *mathematically accurate* crochet patterns. For example, the current standard method for making a crochet sphere is technically to make a cone, followed by a cylinder, followed by another cone, and once stuffed these shapes end up looking pretty close to a sphere. This program uses math to make an actual sphere of any size (which is helpful as the standard method looks less like a sphere in larger sizes).

### Other Crocheters Who Gave me Inspiration

I am NOT the first person to wanted to make mathematically accurate crochet sphere. MsPremiseConclusion is the one who gave me the idea via this article https://mspremiseconclusion.wordpress.com/2010/03/14/the-ideal-crochet-sphere/. The math I use in this program to make a sphere is entirely of her creation, however the code is all original. At time of writing, this program doesn't make any other shapes, but I plan to add more soon. The math for those shapes will likely be similar to the math for a sphere, and thus I again thank MsPremiseConclusion for introducing this general method of making mathematically accurate crochet shapes.

### Glossary of Crochet Terms

- **Stitch:** a single unit of crochet that is repeated over and over again to make a crochet item. *Abbreviation: st*
- **Row:** one length of 2D crochet; these lengths are stacked on top of each other to make a flat shape (e.g. rectangles, triangles). One row is created by making a line of stitches in one direction, and the next row is created by making a line of stitches in the other direction.
- **Round:** one length of 3D crochet; these lengths are also stacked on top of each other, but they make 3D shapes (e.g. spheres). One round is created by making a circle of stitches, and the next round is created by making another circle directly on top of the previous, forming a tight spiral shape. *Abbreviation: rd*
- **Chain stitch:** the foundational crochet stitch; it serves as the foundation for a lot of crochet items, as it can be made with just a strand of yarn. *Abbreviation: ch*
- **"Worked into":** crochet is a process of pulling loops of yarn (aka stitches) through other loops of yarn (aka stitches). The stitch currently being made is "worked into" the previous stitch (i.e. the loop currently being made is worked into, aka pulled through, the previous loop). 
- **Single crochet:** the most basic crochet stitch; it makes up most of the volume of Amigurumi crochet items, and must be worked into one stitch. *Abbreviation: sc*
- **Increase:** the stitch used to increase the size of an item; it increases the total stitches in a row or round by one, and must be worked into one stitch. *Abbreviation: inc*
- **Decrease:** the stitch used to decrease the size of an item: it decreases the total stitches in a row or round by one, and must be worked into two stitches. *Abbreviation: dec*

## How the Program Works

### Shapes it can Currently Make *Correctly*

*Assuming I remembered to update the readme after making changes*
- None

### Shapes it can Currently Make *Incorrectly*

*Assuming I remembered to update the readme after making changes*
- Sphere: when prompted by the program, enter the radius of your desired sphere in inches, your crochet stitch gauge, and your crochet round gauge, and it will generate a pattern that will allow you to make a sphere of that size. *For details on how it is making a sphere incorrectly, see the issues page on the GitHub.*


- walk through of logic of crochet pattern making
- basic structure of code
- how to run