/**
 */
package corvus.domain.org.eclipse.core.resources;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.TextMarker#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharStart <em>Char Start</em>}</li>
 *   <li>{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharEnd <em>Char End</em>}</li>
 * </ul>
 *
 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getTextMarker()
 * @model
 * @generated
 */
public interface TextMarker extends IMarker {
	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getTextMarker_LineNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Char Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char Start</em>' attribute.
	 * @see #setCharStart(int)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getTextMarker_CharStart()
	 * @model unique="false"
	 * @generated
	 */
	int getCharStart();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharStart <em>Char Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char Start</em>' attribute.
	 * @see #getCharStart()
	 * @generated
	 */
	void setCharStart(int value);

	/**
	 * Returns the value of the '<em><b>Char End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Char End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Char End</em>' attribute.
	 * @see #setCharEnd(int)
	 * @see corvus.domain.org.eclipse.core.resources.ResourcesPackage#getTextMarker_CharEnd()
	 * @model unique="false"
	 * @generated
	 */
	int getCharEnd();

	/**
	 * Sets the value of the '{@link corvus.domain.org.eclipse.core.resources.TextMarker#getCharEnd <em>Char End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Char End</em>' attribute.
	 * @see #getCharEnd()
	 * @generated
	 */
	void setCharEnd(int value);

} // TextMarker
