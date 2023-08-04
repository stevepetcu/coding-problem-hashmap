package com.stefanpetcu.codingproblemhashmap.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class StringsHashMapTest {

    private lateinit var subject: StringsHashMap;

    @BeforeEach
    fun setUp() {
        subject = StringsHashMap();
    }

    @Test
    fun hashMap_isInitialisedWithAnEmptySetOfValues() {
        assertEquals(0, subject.values.size)
    }

    @Test
    fun canAddAndGetValuesToAndFromNewBuckets_givenABucketDoesNotExistForTheValueHash() {
        subject.add("qwe")
        subject.add("rty")

        assertEquals(2, subject.values.size)
        assertEquals("qwe", subject.get("qwe").get())
        assertEquals("rty", subject.get("rty").get())
    }

    @Test
    fun canAddAndGetValuesToAndFromTheSameBucket_givenTheirHashesMatch() {
        subject.add("qwe")
        subject.add("ewq")

        assertEquals(1, subject.values.size)
        assertEquals("qwe", subject.get("qwe").get())
        assertEquals("ewq", subject.get("ewq").get())
    }

    @Test
    fun get_returnsEmptyOptional_givenTheBucketForAValueDoesNotExist() {
        assertTrue(subject.get("ewq").isEmpty)
    }

    @Test
    fun get_returnsEmptyOptional_givenTheBucketForAValueExistsButTheValueDoesNotExist() {
        subject.add("qwe")

        assertTrue(subject.get("ewq").isEmpty)
    }
}
