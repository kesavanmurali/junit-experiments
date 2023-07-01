# Junit-experiments

## Step-1 : Basics of JUnit testing

### Essential Annotations
    Following are the basic annotations used in JUnit
    
    @Test
        To annotate a method to represents a JUnit unit test case.
        Should not be private or static.  Generally, don't accept any parameters.

    @Before
        A dedicated setup method in a test class will be annoted with @Before.
        This is expected to perform all the initialization before a test case runs.

    @After
        Just like @Before, a teardown method will annoted with @After.
        To clean up after a test case runs.

    @SpringBootTest
        To annotate a test class - will hold one or more Junit test cases.
        Ensures the spring related configuration and cotainers are initialized and ready to be tested/mocked with.
    
    @BeforeClass/@AfterClass
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

## Best Practices
    
    A test case should hold a single aspect to test.  Multiple aspects can be split in more than one testcases. 
    Test method names should represent the actual test flow or business flow.  Usually it goes longer methods names than usual.
    
    