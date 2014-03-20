package ru.orangesoftware.financisto.test.utils;

import android.test.AndroidTestCase;
import ru.orangesoftware.financisto.model.Category;

import static ru.orangesoftware.financisto.utils.TransactionTitleUtils.*;

/**
 * Created by IntelliJ IDEA.
 * User: Denis Solonenko
 * Date: 2/18/11 7:15 PM
 */
public class TransactionTitleUtilsTest extends AndroidTestCase {

    public void test_should_generate_title_for_regular_transactions() {
        assertEquals("", generateTransactionTitle(sb(), null, null, null, Category.NO_CATEGORY_ID, null));
        assertEquals("Payee", generateTransactionTitle(sb(), "Payee", null, null, Category.NO_CATEGORY_ID, null));
        assertEquals("Note", generateTransactionTitle(sb(), null, "Note", null, Category.NO_CATEGORY_ID, null));
        assertEquals("Location", generateTransactionTitle(sb(), null, null, "Location", Category.NO_CATEGORY_ID, null));
        assertEquals("Category", generateTransactionTitle(sb(), null, null, null, Category.NO_CATEGORY_ID, "Category"));
        assertEquals("Payee: Location: Note", generateTransactionTitle(sb(), "Payee", "Note", "Location", Category.NO_CATEGORY_ID, null));
        assertEquals("Category (Location)", generateTransactionTitle(sb(), null, null, "Location", Category.NO_CATEGORY_ID, "Category"));
        assertEquals("Category (Payee: Note)", generateTransactionTitle(sb(), "Payee", "Note", null, Category.NO_CATEGORY_ID, "Category"));
    }

    public void test_should_generate_title_for_a_split() {
        assertEquals("[Split...]", generateTransactionTitle(sb(), null, null, null, Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[Payee...]", generateTransactionTitle(sb(), "Payee", null, null, Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[...] Note", generateTransactionTitle(sb(), null, "Note", null, Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[...] Location", generateTransactionTitle(sb(), null, null, "Location", Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[Payee...] Location: Note", generateTransactionTitle(sb(), "Payee", "Note", "Location", Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[...] Location", generateTransactionTitle(sb(), null, null, "Location", Category.SPLIT_CATEGORY_ID, "[Split...]"));
        assertEquals("[Payee...] Note", generateTransactionTitle(sb(), "Payee", "Note", null, Category.SPLIT_CATEGORY_ID, "[Split...]"));
    }

    private StringBuilder sb() {
        return new StringBuilder();
    }

}
