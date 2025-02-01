# crochet-pattern-maker

### What is Crochet?

Crochet is the process of using yarn and a crochet hook (a specially shaped rod with a hook on the end) to create a kind of fabric. The way this fabric is created determines its shape and therefore allows it to be made into large variety of items. This program is specifically for Amigurumi, which is the process of using crochet to make 3D items (e.g. plushies).

### What are Crochet Patterns?

Crochet patterns are a set of instructions that crocheters use to make a specific item. Most crocheters find patterns online to help them make the items they want, but some make their own patterns. Making a pattern requires familiarity with techniques to make common shapes, as well as a decent understanding of the math/logical process that is behind creating good-looking shapes with crochet.

### What is the Purpose of This Program?

This program is designed to help crocheters make their own patterns. I have taken the implicit logic that is used to make crochet patterns and explicitly stated it as code so that my program can generate a crochet pattern based of the given specifications. While it cannot immediately make a pattern for a specific item (e.g. a sheep), it can make basic shapes that can be combined to make those items (e.g. a sphere for the body).

A secondary purpose of this program is to make *mathematically accurate* crochet patterns. For example, the current standard method for making a crochet sphere is technically to make a cone, followed by a cylinder, followed by another cone, and once stuffed these shapes end up looking pretty close to a sphere. This program uses math to make an actual sphere of any size (which is helpful as the standard method looks less like a sphere in larger sizes).

### Other Crocheters Who Gave me Inspiration

I am NOT the first person to wanted to make mathematically accurate crochet sphere. MsPremiseConclusion is the one who gave me the idea via this article https://mspremiseconclusion.wordpress.com/2010/03/14/the-ideal-crochet-sphere/. The math I use in this program to make a sphere is entirely of her creation, however the code is all original. At time of writing, this program doesn't make any other shapes, but I plan to add more soon. The math for those shapes will likely be similar to the math for a sphere, and thus I again thank MsPremiseConclusion for introducing this general method of making mathematically accurate crochet shapes.

### Shapes it can Currently Make *Correctly*

*Assuming I remembered to update the readme after making changes*
- None

### Shapes it can Currently Make *Incorrectly*

*Assuming I remembered to update the readme after making changes*
- Sphere: when prompted by the program, enter the radius of your desired sphere in inches, your crochet stitch gauge, and your crochet round gauge, and it will generate a pattern that will allow you to make a sphere of that size.


- glosasry
- walk through of logic of crochet pattern making
- basic structure of code