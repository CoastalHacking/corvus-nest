/**
 */
package corvus.domain.org.eclipse.core.resources.impl;

import corvus.domain.org.eclipse.core.resources.ResourcesPackage;
import corvus.domain.org.eclipse.core.resources.TextMarker;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Marker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl#getCharStart <em>Char Start</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.impl.TextMarkerImpl#getCharEnd <em>Char End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextMarkerImpl extends IMarkerImpl implements TextMarker {
	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharStart() <em>Char Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharStart()
	 * @generated
	 * @ordered
	 */
	protected static final int CHAR_START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCharStart() <em>Char Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharStart()
	 * @generated
	 * @ordered
	 */
	protected int charStart = CHAR_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharEnd() <em>Char End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int CHAR_END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCharEnd() <em>Char End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharEnd()
	 * @generated
	 * @ordered
	 */
	protected int charEnd = CHAR_END_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextMarkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcesPackage.Literals.TEXT_MARKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.TEXT_MARKER__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCharStart() {
		return charStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharStart(int newCharStart) {
		int oldCharStart = charStart;
		charStart = newCharStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.TEXT_MARKER__CHAR_START, oldCharStart, charStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCharEnd() {
		return charEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharEnd(int newCharEnd) {
		int oldCharEnd = charEnd;
		charEnd = newCharEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcesPackage.TEXT_MARKER__CHAR_END, oldCharEnd, charEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcesPackage.TEXT_MARKER__LINE_NUMBER:
				return getLineNumber();
			case ResourcesPackage.TEXT_MARKER__CHAR_START:
				return getCharStart();
			case ResourcesPackage.TEXT_MARKER__CHAR_END:
				return getCharEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourcesPackage.TEXT_MARKER__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case ResourcesPackage.TEXT_MARKER__CHAR_START:
				setCharStart((Integer)newValue);
				return;
			case ResourcesPackage.TEXT_MARKER__CHAR_END:
				setCharEnd((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResourcesPackage.TEXT_MARKER__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case ResourcesPackage.TEXT_MARKER__CHAR_START:
				setCharStart(CHAR_START_EDEFAULT);
				return;
			case ResourcesPackage.TEXT_MARKER__CHAR_END:
				setCharEnd(CHAR_END_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResourcesPackage.TEXT_MARKER__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case ResourcesPackage.TEXT_MARKER__CHAR_START:
				return charStart != CHAR_START_EDEFAULT;
			case ResourcesPackage.TEXT_MARKER__CHAR_END:
				return charEnd != CHAR_END_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lineNumber: ");
		result.append(lineNumber);
		result.append(", charStart: ");
		result.append(charStart);
		result.append(", charEnd: ");
		result.append(charEnd);
		result.append(')');
		return result.toString();
	}

} //TextMarkerImpl
