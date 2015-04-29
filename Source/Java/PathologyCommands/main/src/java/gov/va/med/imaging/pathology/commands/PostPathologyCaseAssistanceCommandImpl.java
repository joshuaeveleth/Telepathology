/**
 * 
  Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: Jun 14, 2012
  Site Name:  Washington OI Field Office, Silver Spring, MD
  Developer:  VHAISWWERFEJ
  Description: 

        ;; +--------------------------------------------------------------------+
        ;; Property of the US Government.
        ;; No permission to copy or redistribute this software is given.
        ;; Use of unreleased versions of this software requires the user
        ;;  to execute a written test agreement with the VistA Imaging
        ;;  Development Office of the Department of Veterans Affairs,
        ;;  telephone (301) 734-0100.
        ;;
        ;; The Food and Drug Administration classifies this software as
        ;; a Class II medical device.  As such, it may not be changed
        ;; in any way.  Modifications to this software may result in an
        ;; adulterated medical device under 21CFR820, the use of which
        ;; is considered to be a violation of US Federal Statutes.
        ;; +--------------------------------------------------------------------+

 */
package gov.va.med.imaging.pathology.commands;

import gov.va.med.RoutingToken;
import gov.va.med.imaging.core.interfaces.exceptions.ConnectionException;
import gov.va.med.imaging.core.interfaces.exceptions.MethodException;
import gov.va.med.imaging.pathology.PathologyCaseUpdateAttributeResult;
import gov.va.med.imaging.pathology.PathologyCaseURN;
import gov.va.med.imaging.pathology.datasource.PathologyDataSourceSpi;
import gov.va.med.imaging.pathology.enums.PathologyCaseAssistance;

/**
 * Add case assistance
 * 
 * @author VHAISWWERFEJ
 *
 */
public class PostPathologyCaseAssistanceCommandImpl
extends AbstractPathologyDataSourceCommandImpl<PathologyCaseUpdateAttributeResult>
{
	private static final long serialVersionUID = -4765580768210950613L;
	
	private final PathologyCaseURN pathologyCaseUrn;
	private final PathologyCaseAssistance assistanceType;
	private final String stationNumber;
	
	public PostPathologyCaseAssistanceCommandImpl(PathologyCaseURN pathologyCaseUrn, PathologyCaseAssistance assistanceType, String stationNumber)
	{
		this.pathologyCaseUrn = pathologyCaseUrn;
		this.assistanceType = assistanceType;
		this.stationNumber = stationNumber;
	}

	public PathologyCaseURN getPathologyCaseUrn()
	{
		return pathologyCaseUrn;
	}

	public PathologyCaseAssistance getAssistanceType()
	{
		return assistanceType;
	}

	public String getStationNumber()
	{
		return stationNumber;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getRoutingToken()
	 */
	@Override
	public RoutingToken getRoutingToken()
	{
		return getPathologyCaseUrn();
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getSpiMethodName()
	 */
	@Override
	protected String getSpiMethodName()
	{
		return "addCaseAssistance";
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getSpiMethodParameterTypes()
	 */
	@Override
	protected Class<?>[] getSpiMethodParameterTypes()
	{
		return new Class<?>[] {PathologyCaseURN.class, PathologyCaseAssistance.class, String.class};
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getSpiMethodParameters()
	 */
	@Override
	protected Object[] getSpiMethodParameters()
	{
		return new Object[] {getPathologyCaseUrn(), getAssistanceType(), getStationNumber()};
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getCommandResult(gov.va.med.imaging.datasource.VersionableDataSourceSpi)
	 */
	@Override
	protected PathologyCaseUpdateAttributeResult getCommandResult(
			PathologyDataSourceSpi spi) 
	throws ConnectionException, MethodException
	{
		return spi.addCaseAssistance(getPathologyCaseUrn(), getAssistanceType(), getStationNumber());
	}

}
