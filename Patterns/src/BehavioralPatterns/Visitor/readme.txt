Посетитель Visitor

Цель:

Описание действий, которые выполняются с каждым объектом в неоторой структуре.

Для чего используют:

Описание операций, которые выполняются с каждым объектом из некторой структуры.
Позволяет определить новую операцию без изменения классов этих объектов.

Пример использования:

- в структуре присуствуют объекты многих классов с различными интерфесами и нам необходимо
выполнить над ними операции, которые зависят от конкретных классов;

- необходимо выполнять не связанные между собой операции над объектами,
которые входят в состав структуры и мы не хотим добавлять эти операции в классы.

- классы, которые устанвливают структуру объектов редко изменяются, но часто
добавляются новые операции над этой структурой