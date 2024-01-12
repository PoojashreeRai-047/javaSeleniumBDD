#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

# Scenario outline
Feature: Epass Status Checkup daily
  I want to use this template for my feature file

  @RPSandRGATest
  Scenario Outline: Title of your scenario outline
    Given Candidate is on the Epass website
    When Goes to Status Page
    When User current details like "<Applicationnumber>" "<AcdmcYear>" are entered
    And User DOB "<DateofBirth>" is entered
    And User enters SSC details like "<SecStuCerType>" "<SSCAcYr>" "<SecStuCerNum>"
    Then All details are Submitted
    And Status page is visible and scrolled

    Examples:
      | Applicationnumber | AcdmcYear | DateofBirth | SecStuCerType | SSCAcYr | SecStuCerNum |
      | 202008437870      | 2020-21   | 04031999    | SSC Regular   | 2015    | 1502115220   |
      | 202110908869      | 2021-22   | 26122003    | SSC Regular   | 2019    | 1922185720   |


#by me
#Feature: Epass Status Checkup daily
#  I want to use this template for my feature file
# 
#@RPSandRGATest
# Scenario Outline: Title of your scenario outline
#   Given Candidate is on the Epasswesite
#   When Goes to Status Page
#   When User current details like <Applicationnumber> <AcdmcYear> are entered
#   And User DOB <DateofBirth> is entered
#   And SSC details like <SecStuCerType> <SSCAcYr> <SecStuCerNum> are entered
#   Then All details are Submitted 
#   And Status page is visble and scrolled
#
#   Examples: 
#      | Applicationnumber | AcdmcYear | DateofBirth | SecStuCerType | SSCAcYr | SecStuCerNum |
#      |      202008437870 |   2020-21 |    04031999 | SSC Regular   |    2015 |   1502115220 |
#      | 202110908869 | 2021-22 | 26122003 | SSC Regular | 2019    | 1922185720 |
 
#@RpsNodataTest
# Scenario: Epass nodata testing
#   Given Candidate is on the Epasswesite
#   When Goes to Status Page
#   When User current details are entered
#   And User DOB is entered
#   And SSC details like are entered
#   Then All details are Submitted 
#   And Status page is visble and scrolled


 # @tag2
 # Scenario Outline: Title of your scenario outline
 #   Given I want to write a step with <name>
 #   When I check for the <value> in step
 #   Then I verify the <status> in step

 #   Examples: 
 #     | name  | value | status  |
 #     | name1 |     5 | success |
 #     | name2 |     7 | Fail    |
#