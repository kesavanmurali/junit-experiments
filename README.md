# Junit-experiments

## Step-1 : Basics of JUnit testing

### Essential Annotations
    Following are the basic annotations used in JUnit
    
    @Test
        To annotate a method to represents a JUnit unit test case.
        Should not be private or static.  Generally, don't accept any parameters.

    @BeforeEach
        A dedicated setup method in a test class will be annoted with @BeforeEach.
        This is expected to perform all the initialization before a test case runs.

    @AfterEach
        Just like @Before, a teardown method will annoted with @AfterEach.
        To clean up after a test case runs.

    @SpringBootTest
        To annotate a test class - will hold one or more Junit test cases.
        Ensures the spring related configuration and cotainers are initialized and ready to be tested/mocked with.
    
    @BeforeAll/@AfterAll
        Methods annotated with this annotation will be run once when the test class is loaded/unloaded respectively.

### Assert Functions
    
    Junit framework provides a set of static methods for evaluating the results of a test case.
    These functions form the basis of whether a test case is passed.
    You may consider like, a test case is passed if all the assert statements are passed.
    
    assertEquals
    assertNotEquals
    assertTrue
    assertFalse
    assertThrows
    assertDoesNotThrow

    Example : MagicNumberBoxTest.java

## Step-2 : Setup and cleanup
    
    In a Junit test class, you may have more than one test cases.  But, each test case may need some
    common initializations of variables.  Those common initialization and cleanup(after test case) can
    be introduced using @BeforeEach and @AfterEach annotations.

    At one more level higher initialzations(Once per test class), @BeforeAll/@AfterAll annotations can 
    be used.  

    Please note that, until Junit4, these methods were named as @Before/@BeforeClass and @After/@AfterClass.
    In Junit5, the names of these annotations were refactored to clear the ambiguity.
    
    Example : BeforeAndAfterSampleTest.java

## Step-3 : Parameterized Testing

    There may be cases where the method under testing may be same, but the arguments can differ.
    Instead of creating test methods individually for different parameters, a single method itself can be used
    for different parameters. 
    
### Setup for parameterized Test

    @ParameterizedTest - Replace @Test with this annotation.
    Define the value source and ensure the test method accepts those parameters.
        - @ValueSource
        - @EnumSource
        - @MethodSource
        - @CsvSource

    Example : MagicNumberBoxParameterizedTest.java

## Step-4 : Stubbing Basics
    
    SUT - System Under Test
        In case of Junit tescases, a class that you want to test is SUT.

    Why Stubbing is needed?
        A SUT might be dependent on other utility classes.  This dependencies may include
        heavy/costly operations like network calls, database access, etc., 
        Sometimes a dependency may be external and may not be available in
        the build environment to test it.
        These dependents more often than not is an another class in java.  So, these classes
        are expected to be stubbed while testing SUT with Junit.

    Problems with Stubbing
        Effort Overhead
            - There could be more than one dependent.
            - For each dependent, the stub needs to implemented, which is timetaking.
        Highly complex for complex dependents
            - Stubs can get as complex as the dependencies and requires high maintenance time.

    Example : TodoBusinessImplStubTest.java

    Alternative to Stubbing: Mocking!!!

## Step-5 : Mocking Basics

    What is mocking?
        Creating a mock object of a dependent class to ensure the SUT class is isolated and tested.
        Mocking the objects happens dynamically at run-time.

    Stubbing Vs Mocking
        Mocking is more dynamic coding.
        Stubbing is a subset of mocking. With mocking frameworks, we can do much more.
        Can verify if a particular method of a class has been called - How many times it was called - With what parameters it was called. 

### Mockito basics

    Mocking a dependency
        <DependentClass> mockObject = mock(<DependentClass>.class);   
        Usually this is they way to create a mock object of a class.  

    Stubbing a dependency
        Generally to stub a method of mock object, the following syntax may be followed.
        when(mockObject.<callingFunction>(<Matcher1>, <Matcher2>)).thenReturn(<ReturnValue>) - where Matchers indicate the parameter type

    Example : TodoBusinessImplMockTest.java

    Fundamentals things
        Nice mock
            If a method is not stubbed, mockito returns a default value depending on the return type.
            For example, if the return type is list, returns an empty list. 0 for integer, false for boolean.
        Verify Interactions
            verify method can be used understand how a method in the mock object were involved in the execution.
        Argument Matchers
            Parameters can be of any value.  Sometimes, the values can be hardcoded.
            But, generally, it is desired to stub a method generically, argument matchers can be used for this purpose.
                - anyInt()
                - anyString()
                - anyLong()
        Argument Captors
            What arguments are being passed to a mock object can be verified by attaching an ArgumentCaptor to the mock.
        Useful stub methods of mock objects
            thenReturn - Return a specific value
            thenThrow - On calling the stubbed method, throw a specified exception.

    Example : MockitoFundamentals.java

## Step-6 : Mockito Annotations

    The following annotations helps minimize the initialization steps that sets up the mocking objects.
    No need to create the objects and preserve, as they will initialized automatically in most cases with the help of annotations.
    
    @Mock 
        Whichever dependent class or member variable is to be mocked, declare a private field in the Junit class annotated with @Mock.
        Mockito looks for the corresponding member variable in the SUT and assigns a mock object to it.
    @InjectMocks
        To define the SUT class as a member variable in the Junit test class.
        It allows the mock to be injected into this testable object.
    @ExtendWith(MockitoExtension.class)
        Runs Junit tests with mockito test runner.
        Another alternative is to use SpringExtension.class, in case the spring features are needed for the run.
    @Captor
        To declare an argument captor member field, that will be initialized automatically for each test case.

    Example : TodoBusinessImplMockAnnotationsTest.java
    

## Best Practices
    
    A test case should hold a single aspect to test.  Multiple aspects can be split in more than one testcases. 
    Test method names should represent the actual test flow or business flow.  Usually it goes longer methods names than usual.
    
    