1. Работа с контролерами  @GetMapping("/hello")
2. Работа с гет запросами и параметарми запроса @RequestParam("name") String name,
в случае если параметры не обязательные тогда @RequestParam(value = "name",required = false)
для передачи в модель данных необходимо в метод добваить Model model
model.addAttribute("result","Result calc: " + result);
в поле html документа досутпно через синтаксис: <p th:text = "${result}"/>
где result - поле в model