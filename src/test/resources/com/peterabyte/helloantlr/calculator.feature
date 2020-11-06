Feature: Calculator parser

  Scenario: Empty calculator
    Given calculator expressions
    """
    a = 4;
    b = 3;
    print(a, b, a - b + 1, 0 + 1);
    """
    Then calculator should return
    """
    4.0
    3.0
    2.0
    1.0
    """