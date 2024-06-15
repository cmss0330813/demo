package com.example.demo;

public class BookSpecification {



    /*
    // like 쿼리 (포함)
    public static Specification<Stock> likeName(String name){
        return new Specification<Stock>() {
            @Override
            public Predicate toPredicate(Root<Stock> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%" + name + "%");
            }
        };
    }

    // between 쿼리 (사이값)
    public static Specification<Stock> betweenDate(LocalDate startDate, LocalDate endDate){
        return new Specification<Stock>() {
            @Override
            public Predicate toPredicate(Root<Stock> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("date"), startDate, endDate);
            }
        };
    }

    // equal 쿼리 (일치)
    public static Specification<Stock> equalName(Long todoId) {
        return new Specification<Stock>() {
            @Override
            public Predicate toPredicate(Root<Stock> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        };
    }


     */
}
