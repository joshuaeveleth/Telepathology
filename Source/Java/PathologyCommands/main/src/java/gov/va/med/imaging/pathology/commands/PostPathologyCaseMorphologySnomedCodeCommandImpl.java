/**
 * 
  Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: Jul 18, 2012
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
import gov.va.med.imaging.pathology.PathologyCaseURN;
import gov.va.med.imaging.pathology.PathologyFieldURN;
import gov.va.med.imaging.pathology.datasource.PathologyDataSourceSpi;

/**
 * Save an etiology snomed code for a morphology
 * 
 * @author VHAISWWERFEJ
 *
 */
public class PostPathologyCaseMorphologySnomedCodeCommandImpl
extends AbstractPathologyDataSourceCommandImpl<String>
{
	private static final long serialVersionUID = -6465727791265395974L;
	
	private final PathologyCaseURN pathologyCaseUrn;
	private final String tissueId;
	private final String morphologyId;
	private final PathologyFieldURN etiologyFieldUrn;

	public PostPathologyCaseMorphologySnomedCodeCommandImpl(
			PathologyCaseURN pathologyCaseUrn, String tissueId,
			String morphologyId, PathologyFieldURN etiologyFieldUrn)
	{
		super();
		this.pathologyCaseUrn = pathologyCaseUrn;
		this.tissueId = tissueId;
		this.morphologyId = morphologyId;
		this.etiologyFieldUrn = etiologyFieldUrn;
	}

	public PathologyCaseURN getPathologyCaseUrn()
	{
		return pathologyCaseUrn;
	}

	public String getTissueId()
	{
		return tissueId;
	}

	public String getMorphologyId()
	{
		return morphologyId;
	}

	public PathologyFieldURN getEtiologyFieldUrn()
	{
		return etiologyFieldUrn;
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
		return "saveCaseEtiologySnomedCodeForMorphology";
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getSpiMethodParameterTypes()
	 */
	@Override
	protected Class<?>[] getSpiMethodParameterTypes()
	{
		return new Class<?>[]{PathologyCaseURN.class, String.class, String.class, PathologyFieldURN.class};
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getSpiMethodParameters()
	 */
	@Override
	protected Object[] getSpiMethodParameters()
	{
		return new Object[] {getPathologyCaseUrn(), getTissueId(), getMorphologyId(), getEtiologyFieldUrn()};
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.core.router.AbstractDataSourceCommandImpl#getCommandResult(gov.va.med.imaging.datasource.VersionableDataSourceSpi)
	 */
	@Override
	protected String getCommandResult(PathologyDataSourceSpi spi)
	throws ConnectionException, MethodException
	{
		return spi.saveCaseEtiologySnomedCodeForMorphology(getPathologyCaseUrn(), 
				getTissueId(), getMorphologyId(), getEtiologyFieldUrn());
	}

}