package home.thienph.xyahoo.data.data;

import java.util.Vector;

public final class ContactGroup {
    public Vector contacts;
    private String groupName;
    private int groupStatus; // (0=collapsed, 1=expanded), 90%

    public ContactGroup(String contactName) {
        this.groupName = contactName;
        this.contacts = new Vector();
    }

    public final void addContact(ContactEntry foundContact) {
        this.contacts.addElement(foundContact);
    }

    public final ContactEntry findContactByName(String string) {
        ContactEntry contactEntry2 = null;
        int n = this.contacts.size();
        while (--n >= 0) {
            ContactEntry contactEntry3 = (ContactEntry)this.contacts.elementAt(n);
            if (!contactEntry3.contactId.equals(string)) continue;
            contactEntry2 = contactEntry3;
            break;
        }
        return contactEntry2;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String string) {
        this.groupName = string;
    }

    public final int getGroupStatus() {
        return this.groupStatus;
    }

    public final void setGroupStatus(int n) {
        this.groupStatus = n;
    }
}
