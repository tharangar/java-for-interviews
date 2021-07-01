

# Technical Writting

https://developers.google.com/tech-writing/one

## Learning objectives

This course teaches you the fundamentals of technical writing. After completing this class, you will know how to do the following:

 *   Use terminology—including abbreviations and acronyms—consistently.
 *   Recognize and disambiguate pesky pronouns.
 *   Distinguish active voice from passive voice.
 *   Convert passive voice sentences to active voice.
 *   Identify three ways in which active voice is superior to passive voice.
 *   Develop at least three strategies to make sentences clearer and more engaging.
 *   Develop at least four strategies to shorten sentences.
 *   Understand the difference between bulleted lists and numbered lists.
 *   Create helpful lists.
 *   Create effective lead sentences for paragraphs.
 *   Focus each paragraph on a single topic.
 *   State key points at the start of each document.
 *   Identify your target audience.
 *   Determine what your target audience already knows and what your target audience needs to learn.
 *   Understand the curse of knowledge.
 *   Identify and revise idioms.
 *   State your document's scope (goals) and audience.
 *   Break long topics into appropriate sections.
 *   Use commas, parentheses, colons, em-dashes, and semicolons properly.
 *   Develop beginner competency in Markdown.

It takes years of focused practice to become a great engineer or a great technical writer. This course will improve your technical writing but will not instantly transform you into a great technical writer.


## Just enough grammer.
https://developers.google.com/tech-writing/one/just-enough-grammar

### Noun
a person, place, concept, or thing
Ex : <B>Sam</B> runs races.

### Pronoun
a noun that replaces another noun (or larger structure)
Ex : <B> He </B> likes to complete

### Adjective
a word or phrase that modifies a noun
Ex : Sam wears blue shoes.

### Verb
an action word or phrase
Ex :Sam runs races.

### Adverb
a word or phrase that modifies a verb, an adjective, or another adverb
Ex : Sam runs slowly.

### Preposition
a word or phrase specifying the positional relationship of two nouns
Ex : Sam's sneakers are seldom on his shelf.  -- > On


### Conjunction
a word that connects two nouns or phrases
Ex : Sam's trophies and ribbons live only in his imagination. - > and

### Transition
a word or phrase that connects two sentences
Ex : Sam runs races weekly. However, he finishes races weakly. ->  However



https://developers.google.com/tech-writing/one/words

## Words

Define new or unfamiliar terms

When writing or editing, learn to recognize terms that might be unfamiliar to some or all of your target audience. When you spot such a term, take one of the following two tactics:

    If the term already exists, link to a good existing explanation. (Don't reinvent the wheel.)
    If your document is introducing the term, define the term. If your document is introducing many terms, collect the definitions into a glossary.

### Use terms consitently.

If you change the name of a variable midway through a method, your code won’t compile. Similarly, if you rename a term in the middle of a document, your ideas won’t compile (in your users’ heads).
The moral: apply the same unambiguous word or term consistently throughout your document. Once you've named a component thingy, don't rename it thingamabob. For example, the following paragraph mistakenly renames Protocol Buffers to protobufs:

```
Protocol Buffers provide their own definition language. Blah, blah, blah. And that's why protobufs have won so many county fairs.
```
Yes, technical writing is cruel and restrictive, but at least technical writing provides an excellent workaround. Namely, when introducing a long-winded concept name or product name, you may also specify a shortened version of that name. Then, you may use that shortened name throughout the document. For example, the following paragraph is fine:

```
Protocol Buffers (or protobufs for short) provide their own definition language. Blah, blah, blah. And that's why protobufs have won so many county fairs.
```


### Use acronyms properly

On the initial use of an unfamiliar acronym within a document or a section, spell out the full term, and then put the acronym in parentheses. Put both the spelled-out version and the acronym in boldface. For example:

```
This document is for engineers who are new to the Telekinetic Tactile Network (TTN) or need to understand how to order TTN replacement parts through finger motions.
```

You may then use the acronym going forward, as in the following example:

```
If no cache entry exists, the Mixer calls the OttoGroup Server (OGS) to fetch Ottos for the request. The OGS is a repository that holds all servable Ottos. The OGS is organized in a logical tree structure, with a root node and two levels of leaf nodes. The OGS root forwards the request to the leaves and collects the responses.
```

Do not cycle back-and-forth between the acronym and the expanded version in the same document.


Use the acronym or the full term?

Sure, you can introduce and use acronyms properly, but should you use acronyms? Well, acronyms do reduce sentence size. For example, TTN is two words shorter than Telekinetic Tactile Network. However, acronyms are really just a layer of abstraction; readers must mentally expand recently learned acronyms to the full term. For example, readers convert TTN to Telekinetic Tactile Network in their heads, so the "shorter" acronym actually takes a little longer to process than the full term.

Heavily used acronyms develop their own identity. After a number of occurrences, readers generally stop expanding acronyms into the full term. Many Web developers, for example, have forgotten what HTML expands to.

Here are the guidelines for acronyms:

*    Don't define acronyms that would only be used a few times.
*    Do define acronyms that meet both of the following criteria:
    *    The acronym is significantly shorter than the full term.
    *    The acronym appears many times in the document.



### Disambiguate pronouns

Many pronouns point to a previously introduced noun. Such pronouns are analogous to pointers in programming. Like pointers in programming, pronouns tend to introduce errors. Using pronouns improperly causes the cognitive equivalent of a null pointer error in your readers’ heads. In many cases, you should simply avoid the pronoun and just reuse the noun. However, the utility of a pronoun sometimes outweighs its risk (as in this sentence).

Consider the following pronoun guidelines:

*   Only use a pronoun after you've introduced the noun; never use the pronoun before you've introduced the noun.
*    Place the pronoun as close as possible to the referring noun. In general, if more than five words separate your noun from your pronoun, consider repeating the noun instead of using the pronoun.
*    If you introduce a second noun between your noun and your pronoun, reuse your noun instead of using a pronoun.

The following pronouns cause the most confusion in technical documentation:

    it
    they, them, and their

For example, in the following sentence, does It refer to Python or to C++?

```
Python is interpreted, while C++ is compiled. It has an almost cult-like following.
```

As another example, what does their refer to in the following sentence?

```
Be careful when using Frambus or Carambola with HoobyScooby or BoiseFram because a bug in their core may cause accidental mass unfriending.
```

This and that

Consider two additional problem pronouns:

    this
    that

For example, in the following ambiguous sentence, This could refer to Frambus, to Foo, or to both:

```
You may use either Frambus or Foo to calculate derivatives. This is not optimal.
```

Use either of the following tactics to disambiguate this and that:

*    Replace this or that with the appropriate noun.
*    Place a noun immediately after this or that.

For example, either of the following sentences disambiguate the previous example:

```
    Overlapping functionality is not optimal.

    This overlapping functionality is not optimal.

```


## Active voice vs. passive voice

The vast majority of sentences in technical writing should be in active voice. This unit teaches you how to do the following:

*    Distinguish passive voice from active voice.
*    Convert passive voice to active voice because active voice is usually clearer.

In an active voice sentence, an actor acts on a target. That is, an active voice sentence follows this formula:
```
    Active Voice Sentence = actor + verb + target
```

A passive voice sentence reverses the formula. That is, a passive voice sentence typically follows the following formula:
```
    Passive Voice Sentence = target + verb + actor
```

Active voice example
For example, here’s a short, active voice sentence:
```
The cat sat on the mat.
```


*    actor: The cat
*    verb: sat
*    target: the mat

Passive voice examples

By contrast, here's that same sentence in passive voice:
```
    The mat was sat on by the cat.
```
*    target: The mat
*    passive verb: was sat
*    actor: the cat

Some passive voice sentences omit an actor. For example:
```
    The mat was sat on.
```
*    actor: unknown
*    passive verb: was sat
*    target: the mat

Who or what sat on the mat? A cat? A dog? A T-Rex? Readers can only guess. Good sentences in technical documentation identify who is doing what to whom.


Recognize passive verbs

Passive verbs typically have the following formula:

```
assive verb = form of be + past participle verb
```

Although the preceding formula looks daunting, it is actually pretty simple:


    A form of be in a passive verb is typically one of the following words:
        is/are
        was/were
    A past participle verb is typically a plain verb plus the suffix ed. For example, the following are past participle verbs:
        interpreted
        generated
        formed

Unfortunately, some past participle verbs are irregular; that is, the past participle form does not end with the suffix ed. For example:

    sat
    known
    frozen

Putting the form of be and the past participle together yields passive verbs, such as the following:

    was interpreted
    is generated
    was formed
    is frozen

If the phrase contains an actor, a preposition ordinarily follows the passive verb. (That preposition is often a key clue to help you spot passive voice.) The following examples combine the passive verb and the preposition:

    was interpreted as
    is generated by
    was formed by
    is frozen by

### Imperative verbs are typically active

It is easy to mistakenly classify sentences starting with an imperative verb as passive. An imperative verb is a command. Many items in numbered lists start with imperative verbs. For example, Open and Set in the following list are both imperative verbs:

1.    Open the configuration file.
2.    Set the Frombus variable to False.

Sentences that start with an imperative verb are typically in active voice, even though they do not explicitly mention an actor. Instead, sentences that start with an imperative verb imply an actor. The implied actor is you.


Distinguish active voice from passive voice in more complex sentences

Many sentences contain multiple verbs, some of which are active and some of which are passive. For example, the following sentence contains two verbs, both of which are in passive voice:


![Active Passive conversion](passive.PNG?raw=true "Active Passive Conversion")

### Prefer active voice to passive voice

Use the active voice most of the time. Use the passive voice sparingly. Active voice provides the following advantages:

    Most readers mentally convert passive voice to active voice. Why subject your readers to extra processing time? By sticking to active voice, readers can skip the preprocessor stage and go straight to compilation.
    Passive voice obfuscates your ideas, turning sentences on their head. Passive voice reports action indirectly.
    Some passive voice sentences omit an actor altogether, which forces the reader to guess the actor's identity.
    Active voice is generally shorter than passive voice.

Be bold—be active.


### Scientific research reports (optional material)

Passive voice runs rampant through certain scientific research reports. In those research reports, experimenters and their equipment often disappear, leading to passive sentences that start off as follows:

    It has been suggested that...
    Data was taken...
    Statistics were calculated...
    Results were evaluated.

Do we know who is doing what to whom? No. Does the passive voice somehow make the information more objective? No.

Many scientific journals have embraced active voice. We encourage the remainder to join the quest for clarity.



## Clear Sentences

Comedy writers seek the funniest results, horror writers strive for the scariest, and technical writers aim for the clearest. In technical writing, clarity takes precedence over all other rules. This unit suggests a few ways to make your sentences beautifully clear.


### Choose strong verbs

Many technical writers believe that the verb is the most important part of a sentence. Pick the right verb and the rest of the sentence will take care of itself. Unfortunately, some writers reuse only a small set of mild verbs, which is like serving your guests stale crackers and soggy lettuce every day. Picking the right verb takes a little more time but produces more satisfying results.

To engage and educate readers, choose precise, strong, specific verbs. Reduce imprecise, weak, or generic verbs, such as the following:

*    forms of be: is, are, am, was, were, etc.
*    occur
*    happen

For example, consider how strengthening the weak verb in the following sentences ignites a more engaging sentence:

|   Weak Verb |   Strong Verb     |
|   The error occurs when clicking the submit button    |   Clicking the submit button triggers the error.  |
|   This error message happens when...  |   The system generates this error message when    |
|   We are very careful to ensure   |   We carefully ensure |


### Reduce there is/there are

Sentences that start with There is or There are marry a generic noun to a generic verb. Generic weddings bore readers. Show true love for your readers by providing a real subject and a real verb.

In the best case scenario, you may simply delete There is or There are (and possibly another word or two later in the sentence). For example, consider the following sentence:

```
There is a variable called met_trick that stores the current accuracy.
```

Removing There is replaces the generic subject with a better subject. For example, either of the following sentences is clearer than the original:


```
    A variable named met_trick stores the current accuracy.

    The met_trick variable stores the current accuracy.

```


You can sometimes repair a There is or There are sentence by moving the true subject and true verb from the end of the sentence to the beginning. For example, notice that the pronoun you appears towards the end of the following sentence:


```
There are two disturbing facts about Perl you should know.
```

Replacing There are with You strengthens the sentence:

```
You should know two disturbing facts about Perl.

```

In still other situations, writers start sentences with There is or There are to avoid the hassle of creating true subjects or verbs. If no subject exists, consider creating one. For example, the following There is sentence does not identify the receiving entity:

```
There is no guarantee that the updates will be received in sequential order.
```

Replacing "There is" with a meaningful subject (such as clients) creates a clearer experience for the reader:

```
Clients might not receive the updates in sequential order.
```

### Minimize certain adjectives and adverbs (optional)

Adjectives and adverbs perform amazingly well in fiction and poetry. Thanks to adjectives, plain old grass becomes prodigal and verdant, while lifeless hair transforms into something lustrous and exuberant. Adverbs push horses to run madly and freely and dogs to bark loudly and ferociously. Unfortunately, adjectives and adverbs sometimes make technical readers bark loudly and ferociously. That's because adjectives and adverbs tend to be too loosely defined and subjective for technical readers. Worse, adjectives and adverbs can make technical documentation sound dangerously like marketing material. For example, consider the following passage from a technical document:

```
Setting this flag makes the application run screamingly fast.
```
Granted, screamingly fast gets readers' attention but not necessarily in a good way. Feed your technical readers factual data instead of marketing speak. Refactor amorphous adverbs and adjectives into objective numerical information. For example:

```
Setting this flag makes the application run 225-250% faster.
```

Does the preceding change strip the sentence of some of its charm? Yes, a little, but the revamped sentence gains accuracy and credibility.


## Short sentences

Software engineers generally try to minimize the number of lines of code in an implementation for the following reasons:

*    Shorter code is typically easier for others to read.
*    Shorter code is typically easier to maintain than longer code.
*    Extra lines of code introduce additional points of failure.

In fact, the same rules apply to technical writing:

*    Shorter documentation reads faster than longer documentation.
*    Shorter documentation is typically easier to maintain than longer documentation.
*    Extra lines of documentation introduce additional points of failure.

Finding the shortest documentation implementation takes time but is ultimately worthwhile. Short sentences communicate more powerfully than long sentences, and short sentences are usually easier to understand than long sentences.

### Focus each sentence on a single idea
Focus each sentence on a single idea, thought, or concept. Just as statements in a program execute a single task, sentences should execute a single idea. For example, the following very long sentence contains multiple thoughts:

```
The late 1950s was a key era for programming languages because IBM introduced Fortran in 1957 and John McCarthy introduced Lisp the following year, which gave programmers both an iterative way of solving problems and a recursive way.
```

Breaking the long sentence into a succession of single-idea sentences yields the following result:

```
The late 1950s was a key era for programming languages. IBM introduced Fortran in 1957. John McCarthy invented Lisp the following year. Consequently, by the late 1950s, programmers could solve problems iteratively or recursively.
```

### Convert some long sentences to lists

Inside many long technical sentences is a list yearning to break free. For example, consider the following sentence:

```
To alter the usual flow of a loop, you may use either a break statement (which hops you out of the current loop) or a continue statement (which skips past the remainder of the current iteration of the current loop).
```

When you see the conjunction or in a long sentence, consider refactoring that sentence into a bulleted list. When you see an embedded list of items or tasks within a long sentence, consider refactoring that sentence into a bulleted or numbered list. For example, the preceding example contains the conjunction or, so let's convert that long sentence to the following bulleted list:


To alter the usual flow of a loop, call one of the following statements:

*    break, which hops you out of the current loop.
*    continue, which skips past the remainder of the current iteration of the current loop. 


### Eliminate or reduce extraneous words

Many sentences contain filler—textual junk food that consumes space without nourishing the reader. For example, see if you can spot the unnecessary words in the following sentence:

```
An input value greater than 100 causes the triggering of logging.
```

Replacing causes the triggering of with the much shorter verb triggers yields a shorter sentence:

```
An input value greater than 100 triggers logging.
```

With practice, you'll spot the extra words and feel enormous happiness in removing or reducing them. For example, consider the following sentence:

```
This design document provides a detailed description of Project Frambus.
```

The phrase provides a detailed description of reduces to the verb describes (or the verb details), so the resulting sentence could become:

```
This design document describes Project Frambus.
```

The following table suggests replacements for a few common bloated phrases:

| Wordy | Concise |
| at this point in time | now |
| determine the location of | find |
| is able to | can |


### Reduce subordinate clauses

A clause is an independent logical fragment of a sentence, which contains an actor and an action. Every sentence contains the following:

*    a main clause
*    zero or more subordinate clauses

Subordinate clauses modify the idea in the main clause. As the name implies, subordinate clauses are less important than the main clause. For example, consider the following sentence:


    Python is an interpreted programming language, which was invented in 1991.

*    main clause: Python is an interpreted programming language

*       subordinate clause: which was invented in 1991


You can usually identify subordinate clauses by the words that introduce them. The following list (by no means complete) shows common words that introduce subordinate clauses:


*    which
*    that
*    because
*    whose
*    until
*    unless
*    since

Some subordinate clauses begin with a comma and some don't. The highlighted subordinate clause in the following sentence, for example, begins with the word because and does not contain a comma:

```
I prefer to code in C++ because I like strong data typing.
```

When editing, scrutinize subordinate clauses. Keep the one sentence = one idea formula in mind. Do the subordinate clauses in a sentence extend the single idea or do they branch off into a separate idea? If the latter, consider dividing the offending subordinate clause(s) into separate sentences.


### Distinguish that from which

In the United States, reserve which for nonessential subordinate clauses, and use that for an essential subordinate clause that the sentence can't live without. For example, the key message in the following sentence is that Python is an interpreted language; the sentence can survive without Guido van Rossum invented:

```
Python is an interpreted language, which Guido van Rossum invented.
```

By contrast, the following sentence requires don't involve linear algebra:

```
Fortran is perfect for mathematical calculations that don't involve linear algebra.
```

If you read a sentence aloud and hear a pause just before the subordinate clause, then use which. If you don't hear a pause, use that. Go back and read the preceding two example sentences. Do you hear the pause in the first sentence?

Place a comma before which; do not place a comma before that.

## Lists and tables

Good lists can transform technical chaos into something orderly. Technical readers generally love lists. Therefore, when writing, seek opportunities to convert prose into lists.


### Choose the correct type of list

The following types of lists dominate technical writing:

*    bulleted lists
*    numbered lists
*    embedded lists

Use a bulleted list for unordered items; use a numbered list for ordered items. In other words:

*    If you rearrange the items in a bulleted list, the list's meaning does not change.
*    If you rearrange the items in a numbered list, the list's meaning changes.

For example, we've made the following a bulleted list because rearranging its items does not change the list's meaning:

```

    Bash provides the following string manipulation mechanisms:

    *    deleting a substring from the start of a string
    *    reading an entire file into one string variable


```


The following list, by contrast, must be a numbered list because rearranging its items would change the list's meaning:



    Take the following steps to reconfigure the server:

    1.    Stop the server.
    2.    Edit the configuration file.
    3.    Restart the server.


An embedded list (sometimes called a run-in list) contains items stuffed within a sentence. For example, the following sentence contains an embedded list with four items.

```
The llamacatcher API enables callers to create and query llamas, analyze alpacas, delete vicugnas, and track dromedaries.
```

Generally speaking, embedded lists are a poor way to present technical information. Try to transform embedded lists into either bulleted lists or numbered lists. For example, you should convert the sentence containing the embedded list into the following passage:

EX :

    The llamacatcher API enables callers to do the following:

*    Create and query llamas.
*        Analyze alpacas.
*        Delete vicugnas.
*        Track dromedaries.


### Keep list items parallel

What separates effective lists from defective lists? Effective lists are parallel; defective lists tend to be nonparallel. All items in a parallel list look like they "belong" together. That is, all items in a parallel list match along the following parameters:



*    grammar
*    logical category
*    capitalization
*    punctuation


Conversely, at least one item in a nonparallel list fails at least one of the preceding consistency checks.

For example, the following list is parallel because all the items are plural nouns (grammar), edible (logical category), lower case (capitalization), and without periods or commas (punctuation)

*    carrots
*    potatoes
*    cabbages

By contrast, the following list is painfully nonparallel along all four parameters:

*    carrots
*    potatoes
*    The summer light obscures all memories of winter.

The following list is parallel because all the items are complete sentences with complete sentence capitalization and punctuation:


*    Carrots contain lots of Vitamin A.
*    Potatoes taste delicious.
*    Cabbages provide oodles of Vitamin K.

The first item in a list establishes a pattern that readers expect to see repeated in subsequent items.


### Start numbered list items with imperative verbs

Consider starting all items in a numbered list with an imperative verb. An imperative verb is a command, such as open or start. For example, notice how all of the items in the following parallel numbered list begin with an imperative verb:

1.    Download the Frambus app from Google Play or iTunes.
2.    Configure the Frambus app's settings.
3.    Start the Frambus app.

The following numbered list is nonparallel because two of the sentences start with an imperative verb, but the third item does not:

1.    Instantiate the Froobus class.
2.    Invoke the Froobus.Salmonella() method.
3.    The process stalls.


### Punctuate items appropriately

If the list item is a sentence, use sentence capitalization and punctuation. Otherwise, do not use sentence capitalization and punctuation. For example, the following list item is a sentence, so we capitalized the M in Most and put a period at the end of the sentence:

*    Most carambolas have five ridges.

However, the following list item is not a sentence, so we left the t in the in lowercase and omitted a period:

*    the color of lemons


### Create useful tables

Analytic minds tend to love tables. Given a page containing multiple paragraphs and a single table, engineers' eyes zoom towards the table.

Consider the following guidelines when creating tables:

*    Label each column with a meaningful header. Don't make readers guess what each column holds.
*    Avoid putting too much text into a table cell. If a table cell holds more than two sentences, ask yourself whether that information belongs in some other format.
*    Although different columns can hold different types of data, strive for parallelism within individual columns. For instance, the cells within a particular table column should not be a mixture of numerical data and famous circus elephants.



### Introduce each list and table

We recommend introducing each list and table with a sentence that tells readers what the list or table represents. In other words, give the list or table context. Terminate the introductory sentence with a colon rather than a period.

Although not a requirement, we recommend putting the word following into the introductory sentence. For example, consider the following introductory sentences:


```


    The following list identifies key performance parameters:

    Take the following steps to install the Frambus package:

    The following table summarizes our product's features against our key competitors' features:

```


## Paragraphs

This unit provides some guidelines on building cohesive paragraphs. But first, here is an inspirational message:


```
The work of writing is simply this: untangling the dependencies among the parts of a topic, and presenting those parts in a logical stream that enables the reader to understand you.
```

### Write a great opening sentence


The opening sentence is the most important sentence of any paragraph. Busy readers focus on opening sentences and sometimes skip over subsequent sentences. Therefore, focus your writing energy on opening sentences.

Good opening sentences establish the paragraph's central point. For example, the following paragraph features an effective opening sentence:

```
A loop runs the same block of code multiple times. For example, suppose you wrote a block of code that detected whether an input line ended with a period. To evaluate a million input lines, create a loop that runs a million times.
```

The preceding opening sentence establishes the theme of the paragraph as an introduction to loops. By contrast, the following opening sentence sends readers in the wrong direction:

```
A block of code is any set of contiguous code within the same function. For example, suppose you wrote a block of code that detected whether an input line ended with a period. To evaluate a million input lines, create a loop that runs a million times.
```

### Focus each paragraph on a single topic

A paragraph should represent an independent unit of logic. Restrict each paragraph to the current topic. Don't describe what will happen in a future topic or what happened in a past topic. When revising, ruthlessly delete (or move to another paragraph) any sentence that doesn't directly relate to the current topic.

For example, assume that the opening sentence of the following paragraph does focus on the correct topic. Can you spot the sentences that should be removed from the following paragraph?

```
The Pythagorean Theorem states that the sum of the squares of both legs of a right triangle is equal to the square of the hypotenuse. The perimeter of a triangle is equal to the sum of the three sides. You can use the Pythagorean Theorem to measure diagonal distances. For example, if you know the length and width of a ping-pong table, you can use the Pythagorean Theorem to determine the diagonal distance. To calculate the perimeter of the ping-pong table, sum the length and the width, and then multiply that sum by 2.
```

We've crossed out the second and fifth sentences to yield a paragraph focused exclusively on the Pythagorean Theorem:

```
The Pythagorean Theorem states that the sum of the squares of both legs of a right triangle is equal to the square of the hypotenuse. The perimeter of a triangle is equal to the sum of the three sides. You can use the Pythagorean Theorem to measure diagonal distances. For example, if you know the length and width of a ping-pong table, you can use the Pythagorean Theorem to determine the diagonal distance. To calculate the perimeter of the ping-pong table, sum the length and the width, and then multiply that sum by 2.
```

### Don't make paragraphs too long or too short

Long paragraphs are visually intimidating. Very long paragraphs form a dreaded "wall of text" that readers ignore. Readers generally welcome paragraphs containing three to five sentences, but will avoid paragraphs containing more than about seven sentences. When revising, consider dividing very long paragraphs into two separate paragraphs.

Conversely, don't make paragraphs too short. If your document contains plenty of one-sentence paragraphs, your organization is faulty. Seek ways to combine those one-sentence paragraphs into cohesive multi-sentence paragraphs or possibly into lists.
Answer what, why, and how

Good paragraphs answer the following three questions:

1.    What are you trying to tell your reader?
2.    Why is it important for the reader to know this?
3.    How should the reader use this knowledge? Alternatively, how should the reader know your point to be true?

For example, the following paragraph answers what, why, and how:


```
    <What>The garp() function returns the delta between a dataset's mean and median. </What>  <Why>Many people believe unquestioningly that a mean always holds the truth. However, a mean is easily influenced by a few very large or very small data points.</Why> <How> Call garp() to help determine whether a few very large or very small data points are influencing the mean too much. A relatively small garp() value suggests that the mean is more meaningful than when the garp() value is relatively high. <How>

```

## Audience

The course designers believe that you are probably comfortable with mathematics. Therefore, this unit begins with an equation:

```
good documentation = knowledge and skills your audience needs to do a task − your audience's current knowledge and skills
```

In other words, make sure your document provides the information your audience needs that your audience doesn't already have. Therefore, this unit explains how to do the following:

*    Define your audience.
*    Determine what your audience needs to learn.
*    Fit documentation to your audience.

As the following video suggests, targeting the wrong audience can be messy:


### Define your audience

Serious documentation efforts spend considerable time and energy on defining their audience. These efforts might involve surveys, user experience studies, focus groups, and documentation testing. You probably don't have that much time, so this unit takes a simpler approach.

Begin by identifying your audience's role(s). Sample roles include:


*    software engineers
*    technical, non-engineer roles (such as technical program managers)
*    scientists
*    professionals in scientific fields (for example, physicians)
*    undergraduate engineering students
*    graduate engineering students
*    non-technical positions


We happily appreciate that many people in non-technical roles have great technical and mathematical skills. However, roles remain an essential first-order approximation in defining your audience. People within the same role generally share certain base skills and knowledge. For example:

*    Most software engineers know popular sorting algorithms, big O notation, and at least one programming language. Therefore, you can depend on software engineers knowing what O(n) means, but you can't depend on non-technical roles knowing O(n).
*    A research report targeted at physicians should look very different from a newspaper article about the same research aimed at a lay audience.
*    A professor's explanation of a new machine learning approach to graduate students should differ from the explanation to first-year undergraduate students.


Writing would be so much easier if everyone in the same role shared exactly the same knowledge. Unfortunately, knowledge within the same role quickly diverges. Amal is an expert in Python, Sharon's expertise is C++, and Micah's is in Java. Kara loves Linux, but David only knows iOS.

Roles, by themselves, are insufficient for defining an audience. That is, you must also consider your audience's proximity to the knowledge. The software engineers in Project Frombus know something about related Project Dingus but nothing about unrelated Project Carambola. The average heart specialist knows more about ear problems than the average software engineer but far less than an audiologist.

Time also affects proximity. Almost all software engineers, for example, studied calculus. However, most software engineers don't use calculus in their jobs, so their knowledge of calculus gradually fades. Conversely, experienced engineers typically know vastly more about their current project than new engineers on the same project.


### Sample audience analysis

The following is a sample audience analysis for fictitious Project Zylmon:

```


    The target audience for Project Zylmon falls into the following roles:

        software engineers
        technical product managers

    The target audience has the following proximity to the knowledge:

        My target audience already knows the Zyljeune APIs, which are somewhat similar to the Zylmon APIs.
        My target audience knows C++, but has not typically built C++ programs in the new Winged Victory development environment.
        My target audience took linear algebra in university, but many members of the team need a refresher on matrix multiplication.

```

### Determine what your audience needs to learn

Write down a list of everything your target audience needs to learn to accomplish goals. In some cases, the list should hold tasks that the target audience needs to perform. For example:

```
After reading the documentation, the audience will know how to do the following tasks:



        Use the Zylmon API to list hotels by price.
        Use the Zylmon API to list hotels by location.
        Use the Zylmon API to list hotels by user ratings.



```

Note that your audience must sometimes master tasks in a certain order. For example, your audience might need to learn how to build and execute programs in a new development environment before learning how to write particular kinds of programs.

If you are writing a design spec, then your list should focus on information your target audience should learn rather than on mastering specific tasks: For example:


```
After reading the design spec, the audience will learn the following:



    *    Three reasons why Zylmon outperforms Zyljeune.

    *    Five reasons why Zylmon consumed 5.25 engineering years to develop.



```


### Fit documentation to your audience

Writing to meet your audience's needs requires unselfish empathy. You must create explanations that satisfy your audience's curiosity rather than your own. How do you step out of yourself in order to fit documentation to the audience? Unfortunately, we can offer no easy answers. We can, however, offer a few parameters to focus on.

#### Vocabulary and concepts

Match your vocabulary to your audience. See Words for help.

Be mindful of proximity. The people on your team probably understand your team's abbreviations, but do people on other teams understand those same abbreviations? As your target audience widens, assume that you must explain more.

Similarly, experienced people on your software team probably understand the implementation details and data structures of your team's project, but nearly everyone else (including new members of your team) does not. Unless you are writing specifically for other experienced members of your team, you typically must explain more than you expect.

#### Curse of knowledge

Experts often suffer from the curse of knowledge, which means that their expert understanding of a topic ruins their explanations to newcomers. As experts, it is easy to forget that novices don’t know what you already know. Novices might not understand explanations that make passing reference to subtle interactions and deep systems that the expert doesn’t stop to explain.

From the novice's point of view, the curse of knowledge is a "File not found" linker error due to a module not yet compiled.


#### Simple words

English has become the dominant language for technical communication worldwide. However, a significant percentage of technical readers are more comfortable in languages other than English. Therefore, prefer simple words over complex words; avoid obsolete or overly-complex English words. Sesquipedalian and rare words repel some readers.

#### Cultural neutrality and idioms

Keep your writing culturally neutral. Do not require readers to understand the intricacies of NASCAR, cricket, or sumo in order to understand how a piece of software works. For example, the following sentence—packed with baseball metaphors as American as apple pie—might puzzle some Parisian readers:

```
If Frambus 5.0 was a solid single, Frambus 6.0 is a stand-up double.
```

Idioms are phrases whose overall meaning differs from the literal meaning of the individual words in that phrase. For example, the following phrases are idioms:

*    a piece of cake
*    Bob's your uncle

Cake? Bob? Most readers from the United States recognize the first idiom; most British readers recognize the second idiom. If you are writing strictly for a British audience, then Bob's your uncle can be fine. However, if you are writing for an international audience, then replace that idiom with this task is done.

Idioms are so deeply ingrained in our speech that the special nonliteral meaning of idioms becomes invisible to us. That is, idioms are another form of the curse of knowledge.

Note that some people in your audience use translation software to read your documentation. Translation software tends to struggle more with cultural references and idioms than with plain, simple English.


## Documents

You can write sentences. You can write paragraphs. Can you organize all those paragraphs into a coherent document?


### State your document's scope

A good document begins by defining its scope. For example:

```
This document describes the overall design of Project Frambus.
```

A better document additionally defines its non-scope--the topics not covered that the target audience might expect your document to cover. For example:

```
This document does not describe the design for the related technology, Project Froobus.
```

Scope and non-scope statements benefit not only the reader but also the writer (you). While writing, if the contents of your document veer away from the scope statement, then you must either refocus your document or modify your scope statement. When reviewing your first draft, delete (or branch off to another document) any sections that don't help satisfy the scope statement.

### State your audience

A good document explicitly specifies its audience. For example:

```
I wrote this document for the test engineers supporting Project Frambus.
```

Beyond the audience's role, a good audience declaration might also specify any prerequisite knowledge or experience. For example:

```
This document assumes that you understand matrix multiplication and how to brew a really good cup of tea.
```

In some cases, the audience declaration must also specify prerequisite documents. For example:

```
You must read "Project Froobus: A New Hope" prior to reading this document.
```

### Establish your key points up front

Engineers and scientists are busy people who won't necessarily read all 76 pages of your design document. Imagine that your peers might only read the first paragraph of page one. When reviewing your documentation, ensure that the start of your document answers your readers' essential questions.

Professional writers focus considerable energy on page one to increase the odds of readers making it to page two. However, page one of any long document is the hardest page to write. Therefore, be prepared to revise page one many times.

Always write a summary for long engineering documents. Although the summary must be very short, expect to spend a lot of time writing it. A boring or confusing summary warns potential readers to stay away.


### Write for your audience

This course repeatedly emphasizes the importance of defining your audience. In this section, we focus on audience definition as a means of organizing your document.

#### Define the audience

Answering the following questions helps you determine what your document should contain:

*    Who is your target audience?
*    What do your readers already know before they read your document?
*    What should your readers know or be able to do after they read your document?

For example, suppose you have invented a new sorting algorithm. The following list contains some potential answers to the preceding questions:

*    My target audience is all the software engineers in my organization.
*    Before reading, most of my target audience studied sorting algorithms in school. However, about 25% of my target audience hasn't implemented or evaluated a sorting algorithm in many years.
*    After reading this document, my target audience will be able to do all of the following:
    *    Implement the algorithm in their choice of programming language.
    *    Identify the two kinds of datasets for which the algorithm outperforms the quicksort algorithm.
    *    Identify the two edge cases in which the algorithm performs poorly.


### Organize for your audience's needs

After defining the audience, organize the document to supply what readers should know or be able to do after reading the document. For example, the outline for the document could look as follows:

1.    Overview of the algorithm
    a.    Comparison to quicksort
    b.    Big O comparison: quicksort vs. new algorithm
2.    Implementations
    a.    Implementation in pseudocode
    b.    Implementation tips
3.    Deeper analysis of algorithm
    a.    Optimal datasets
    b.    Edge case problems


### Break your topic into sections

You modularize code into files, classes, and methods. Modular code is easier to read, understand, maintain, and reuse. Making your document modular gives you the same benefits. You probably have strong intuition about functional modularity in code, but how do you apply those principles to your writing?

Imagine that you have an empty jar, which you need to pack with a collection of large rocks, coarse gravel, and sand. How would you pack the jar to ensure that you can get all of your material in the jar? Of course you’d place the large rocks first, then pour in the gravel, and fill in the remaining air space with the sand. If you tried to do this in the opposite order, you would fail.

Your reader’s head is much like an empty jar. The information to document generally comes in three sizes: large rocks, gravel, and sand. You need to structure the space inside your reader’s jar-head with the rocks to accept the rest of the information.

The big rocks are top-level section headers. The gravel is low-level section headers. The sand is paragraphs and lists. What is a big rock and what is gravel? One strategy is to record yourself talking, or free-write, about your topic for a short amount of time—maybe just 2 to 5 minutes. Yes, this takes discipline. Examine what you produced. Did you do the following?

    Describe concepts in vague, under-specified ways?
    List the steps that your audience needs to complete to reach a goal?

The under-specified things that you referred to are probably the large concepts that structure your topic. If your talk didn’t do this, go back and try this structure.



## Punctuation  

### Commas

Programming languages enforce clear rules about punctuation. In English, by contrast, the rules regarding commas are somewhat hazier. As a guideline, insert a comma wherever a reader would naturally pause somewhere within a sentence. For the musically inclined, if a period is a whole note rest, then a comma is perhaps a half-note or quarter-note rest. In other words, the pause for a comma is shorter than that for a period. For example, if you read the following sentence aloud, you probably rest briefly before the word just:

```
C behaves as a mid-level language, just a couple of steps up in abstraction from assembly language.
```

Some situations require a comma. For example, use commas to separate items in an embedded list like the following:

```
Our company uses C++, Python, Java, and JavaScript.
```

You might be wondering about a list's final comma, the one inserted between items N-1 and N. This comma—known as the serial comma or Oxford comma—is controversial. We recommend supplying that final comma simply because technical writing requires picking the least ambiguous solution. That said, we actually prefer circumventing the controversy by converting embedded lists into bulleted lists.

In sentences that express a condition, place a comma between the condition and the consequence. For example, both of the following sentences supply the comma in the correct place:

```


    If the program runs slowly, try the --perf flag.

    If the program runs slowly, then try the --perf flag.

```


You can also wedge a quick definition or digression between a pair of commas as in the following example:

```
Python, an easy-to-use language, has gained significant momentum in recent years.
```

Finally, avoid using a comma to paste together two independent thoughts. For example, the comma in the following sentence is guilty of a punctuation felony called a comma splice:

```
Samantha is a wonderful coder, she writes abundant tests.
```

Use a period rather than a comma to separate two independent thoughts. For example:

```
Samantha is a wonderful coder. She writes abundant tests.
```

### Semicolons

A period separates distinct thoughts; a semicolon unites highly related thoughts. For example, notice how the semicolon in the following sentence unites the first and second thoughts:

```
Rerun Frambus after updating your configuration file; don't rerun Frambus after updating existing source code.
```

The thoughts preceding and following the semicolon must each be grammatically complete sentences. For example, the following semicolon is incorrect because the passage following the semicolon is not a complete sentence:

```
Rerun Frambus after updating your configuration file; not after updating existing source code.
```

Before using a semicolon, ask yourself whether the sentence would still make sense if you flipped the thoughts to opposite sides of the semicolon. For example, reversing the earlier example still yields a valid sentence:

```
Don't rerun Frambus after updating existing source code; rerun Frambus after updating your configuration file.
```

You should almost always use commas, not semicolons, to separate items in an embedded list. For example, the following use of semicolons is incorrect:

```
Style guides are bigger than the moon; more essential than oxygen; and completely inscrutable.
```

Many sentences place a transition word or phrase immediately after the semicolon. In this situation, place a comma after the transition. Note the comma after the transition in the following two examples:

```
Frambus provides no official open source package for string manipulation; however, subsets of string manipulation packages are available from other open source projects.

Even seemingly trivial code changes can cause bugs; therefore, write abundant unit tests.
```

### Em-Dashes

Em-dashes are compelling punctuation marks, rich with punctuation possibilities. An em-dash represents a longer pause—a bigger break—than a comma. If a comma is a quarter note rest, then an em-dash is a half-note rest. For example:

```
C++ is a rich language—one requiring extensive experience to master.
```

Writers sometimes use a pair of em-dashes to block off a digression, as in the following example:

```
Protocol Buffers—often nicknamed protobufs—encode structured data in an efficient yet extensible format.
```

Could we have used commas instead of em-dashes in the preceding examples? Sure. Why did we choose an em-dash instead of a comma? Feel. Art. Experience. Remember—punctuation in English is squishy and malleable.


### Parentheses

Use parentheses to hold minor points and digressions. Parentheses inform readers that the enclosed text isn't critical. Because the enclosed text isn't critical, some editors feel that text that deserves parentheses doesn't deserve to be in the document. As a compromise, keep parentheses to a minimum in technical writing.

The rules regarding periods and parentheses aren't always clear. Here are the standard rules:

*    If a pair of parentheses holds an entire sentence, the period goes inside the closing parenthesis.
*    If a pair of parentheses ends a sentence but does not hold the entire sentence, the period goes just outside the closing parenthesis.

For example:
```
    (Incidentally, Protocol Buffers make great birthday gifts.)

    Binary mode relies on the more compact native form (described later in this document).
```



## Markdown

Markdown is a lightweight markup language that many technical professionals use to create and edit technical documents. With Markdown, you write text in a plain text editor (such as vi or Emacs), inserting special characters to create headers, boldface, bullets, and so on. For example, the following example shows a simple technical document formatted with Markdown: ( Which is used to write down this document)

```
## bash and ksh

**bash** closely resembles an older shell named **ksh**.  The key
*practical* difference between the two shells is as follows:

*  More people know bash than ksh, so it is easier to get help for bash
   problems than ksh problems.

```
Ex :

## bash and ksh

**bash** closely resembles an older shell named **ksh**.  The key
*practical* difference between the two shells is as follows:

*  More people know bash than ksh, so it is easier to get help for bash
   problems than ksh problems.

A Markdown parser converts Markdown files into HTML. Browsers can then display the resulting HTML to readers.

We recommend becoming comfortable with Markdown by taking one of the following tutorials:

    www.markdowntutorial.com
    Mastering Markdown

What's next?

Congratulations: you've completed the pre-class work for Technical Writing One.

If the in-class portion of Technical Writing One is available in your organization, please take it. If you'd like to facilitate the in-class portion of Technical Writing One, see the facilitator's guide.



***


# Technical Writting two.

https://developers.google.com/tech-writing/two

## Technical Writing Two introductionbookmark_border

Technical Writing Two helps technical people improve their technical communication skills.
Target audience

We've aimed this course at people who have completed Technical Writing One and are still hungry for more technical writing training. If you've never taken any technical writing training, we recommend completing Technical Writing One before taking this class.
Learning objectives

This course focuses on several intermediate topics in technical writing. After completing this class, you will know how to do the following:

    Choose among several different tactics to write first drafts and additional tactics for writing second and third drafts.
    Use several techniques to detect mistakes in your own writing.
    Organize large documents.
    Introduce a document's scope and any prerequisites.
    Write clear figure captions.
    Pick the proper information density in technical illustrations.
    Focus the reader's attention in illustrations.
    Establish context through a "big picture" illustration.
    Revise technical illustrations effectively.
    Create useful, accurate, concise, clear, reusable, and well-commented sample code that demonstrates a range of complexity.
    Identify different documentation types.
    Describe just about anything.
    Empathize with a beginner audience and write a tutorial for them.

It takes years of focused practice to become a great engineer or a great technical writer. This course will improve your technical writing but will not instantly transform you into a great technical writer.
Pre-class and in-class components

The course consists of the following two components:

    pre-class
    in-class

You are currently viewing the start of the pre-class component.

The in-class component enhances the lessons taught in the pre-class components. That said, the pre-class lessons on their own still provide a valuable educational experience.
Hardware and network requirements

Although this course is optimized for a laptop or desktop, you may take the course on a tablet or phone. If you are taking the in-class component, please note that you'll type a lot.

You need an internet connection to take the course. You cannot download the course. The course is not available on tangible media.

The course contains a few short videos, all of which are optional viewing. If you want to skip the videos, then you can take the course on a low-bandwidth internet connection.


## Self-editingbookmark_border

Estimated Time: 10 minutes

Imagine that you just wrote the first draft of a document. How do you make it better? In most cases, working towards a final published document is an iterative process. Transforming a blank page into a first draft is often the hardest step. After you write a first draft, make sure you set aside plenty of time to refine your document.

The editing tips in this unit can help turn your first draft into a document that more clearly communicates the information your audience needs. Use one tip or use them all; the important thing is to find a strategy that works for you, and then make that strategy part of your writing routine.
Note: The tips in this unit build on the basic writing and editing skills from Technical Writing One. This unit includes a summary of useful editing techniques from that course. For a more detailed refresher, visit the self-study units from Technical Writing One.


### Adopt a style guide

Companies, organizations, and large open source projects frequently either adopt an existing style guide for their documentation or write their own. Many of the documentation projects on the Google Developers site follow the Google Developer Documentation Style Guide. If you've never relied on a style guide before, at first glance the Google Developer Documentation Style Guide might seem a little intimidating, offering detailed guidance on topics such as grammar, punctuation, formatting, and documenting computer interfaces. You might prefer to start by adopting the style-guide highlights.
Note: For smaller projects, such as team documentation or a small open source project, you might find the highlights are all you need.

Some of the guidelines listed in the highlights are covered in Technical Writing One. You might recall some of the following techniques:

    Use active voice to make clear who's performing the action.
    Format sequential steps as numbered lists.
    Format most other lists as bulleted lists.

The highlights introduce many other techniques that can be useful when writing technical documentation, such as:

    Write in the second person. Refer to your audience as "you" rather than "we".
    Place conditional clauses before an instruction, rather than after.
    Format code-related text as code font.

### Think like your audience

Who is your audience? Step back and try to read your draft from their point of view. Make sure the purpose of your document is clear, and provide definitions for any terms or concepts that might be unfamiliar to your readers.

It can be helpful to outline a persona for your audience. A persona can consist of any of the following attributes:

    A role, such as Systems Engineer or QA Tester.
    An end goal, such as Restore the database.
    A set of assumptions about the persona and their knowledge and experience. For example, you might assume that your persona is:
        Familiar with Python.
        Running a Linux operating system.
        Comfortable following instructions for the command line.

You can then review your draft with your persona in mind. It can be especially useful to tell your audience about any assumptions you've made. You can also provide links to resources where they can learn more if they need to brush up on a specific topic.

Note that relying too heavily on a persona (or two) can result in a document that is too narrowly focused to be useful to the majority of your readers.

For a refresher and more information on this topic from Technical Writing One, see the Audience self-study unit.

### Read it out loud

Depending on the context, the style of your writing can alienate, engage, or even bore your audience. The desired style of a given document depends to an extent on the audience. For example, the contributor guide for a new open source project aimed at recruiting volunteers might adopt a more informal and conversational style, while the developer guide for a commercial enterprise application might adopt a more formal style.

To check your writing is conversational, read it out loud. Listen for awkward phrasing, too-long sentences, or anything else that doesn't feel natural. Alternatively, consider using a screen reader to voice the content for you.

For more information on adjusting the style of your writing to suit your audience, see Style and authorial tone.

### Come back to it later

After you write your first draft (or second or third), set it aside. Come back to it after an hour (or two or three) and try to read it with fresh eyes. You'll almost always notice something that you could improve.

### Change the context

Some writers like to print their documentation and review a paper copy, red pencil in hand. A change of context when reviewing your own work can help you find things to improve. For a modern take on this classic tip, copy your draft into a different document and change the font, size, and color.

### Find a peer editor
Just as engineers need peers to review their code, writers need editors to give them feedback on docs. Ask someone to review your document and give you specific, constructive comments. Your peer editor doesn't need to be a subject matter expert on the technical topic of your document, but they do need to be familiar with the style guide you follow.