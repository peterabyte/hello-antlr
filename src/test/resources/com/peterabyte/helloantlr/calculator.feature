Feature: Calculator

  Scenario: Empty calculator
    Given calculator expressions
    """
    """
    Then calculator should return
    """
    """

  Scenario: Simple print function
    Given calculator expressions
    """
    print(1);
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Print variable
    Given calculator expressions
    """
    a = 1;
    print(a);
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Print variables
    Given calculator expressions
    """
    a = 1;
    b = 2;
    print(a, b, a + b);
    """
    Then calculator should return
    """
    1.0
    2.0
    3.0
    """

  Scenario: Min single number
    Given calculator expressions
    """
    print(min(1));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Min with variable
    Given calculator expressions
    """
    a = 1;
    b = 2;
    print(min(a, b, a + b));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Max single number
    Given calculator expressions
    """
    print(max(1));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Max with variable
    Given calculator expressions
    """
    a = 1;
    b = 2;
    print(max(a, b, a + b));
    """
    Then calculator should return
    """
    3.0
    """

  Scenario: Abs negative number
    Given calculator expressions
    """
    print(abs(-1));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Abs with negative variable
    Given calculator expressions
    """
    a = -1;
    print(abs(a));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Abs positive number
    Given calculator expressions
    """
    print(abs(1));
    """
    Then calculator should return
    """
    1.0
    """

  Scenario: Abs with positive variable
    Given calculator expressions
    """
    a = 1;
    print(abs(a));
    """
    Then calculator should return
    """
    1.0
    """