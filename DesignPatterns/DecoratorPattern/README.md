## Decorator Design Pattern

1. Inheritance is one form of extension, but not necessarily the best way to achieve flexibility in our designs.

2. In our designs we should allow behavior to be extended without the need to modify existing code.

3. Composition and delegation can often be used to add new behaviours at runtime.

4. The Decorator Pattern provides an alternative to subclassing for extending behavior.

5. The Decorator Pattern involves a set of decorator classes that are used to wrap concrete components.

6.  Decorator classes mirror the type of the components they decorate. (In fact, they are the same type as the components they decorate, either through inheritance or interface implementation.)

7. Decorator change the behavior of their components by adding new functionality before and/or after (or even in place of) mthod calls to the component.

8. You can wrap a component with any number of decorators.

9. Decorators are typically transparent to the client of the component: that is unless the client is relying on the component's concrete type.

10. Decorators can result in many small objects in our design, and overuse can be complex.



![Decorator pattern in java io](javaio.png?raw=true "decorator pattern")