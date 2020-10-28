Feature: Calculator parser

  Scenario: Empty calculator
    Given calculator expressions
    """
    1 + 1;
    """
    Then calculator should return
    """
    """