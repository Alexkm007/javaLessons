Паттерн можно часто встретить в Java-коде, особенно там, где требуется пошаговое создание
продуктов или конфигурация сложных объектов.

Паттерн широко используется в стандартных библиотеках Java:

java.lang.StringBuilder#append() (unsynchronized)
java.lang.StringBuffer#append() (synchronized)
java.nio.ByteBuffer#put() (также в CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer и DoubleBuffer)
javax.swing.GroupLayout.Group#addComponent()
Все реализации java.lang.Appendable

Признаки применения паттерна: Строителя можно узнать в классе, который имеет один создающий метод и несколько методов
настройки создаваемого продукта. Обычно, методы настройки вызывают для удобства цепочкой
(например, someBuilder->setValueA(1)->setValueB(2)->create()).