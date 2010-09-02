/*
 * OpenBench LogicSniffer / SUMP project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
 *
 * Copyright (C) 2006-2010 Michael Poppitz, www.sump.org
 * Copyright (C) 2010 J.W. Janssen, www.lxtreme.nl
 */
package nl.lxtreme.ols.tool.base;


import javax.swing.*;

import nl.lxtreme.ols.api.data.*;


/**
 * Provides a base class for tools wishing to do their processing in the
 * background.
 * <p>
 * For convenience, this base class provides direct access to all captured data.
 * </p>
 * 
 * @see SwingWorker
 * @see CapturedData
 */
public abstract class BaseAsyncToolWorker<T> extends SwingWorker<T, Integer> implements CapturedData
{
  // VARIABLES

  private final DataContainer data;

  // CONSTRUCTORS

  /**
   * Creates a new BaseToolWorker instance.
   * 
   * @param aData
   *          the data container to work with, could be <code>null</code>.
   */
  public BaseAsyncToolWorker( final DataContainer aData )
  {
    this.data = aData;
  }

  // METHODS

  /**
   * @see DataContainer#addChannelAnnotation(int, long, long, Object)
   */
  public final void addChannelAnnotation( final int aChannelIdx, final long aStartIdx, final long aEndIdx,
      final Object aData )
  {
    this.data.addChannelAnnotation( aChannelIdx, aStartIdx, aEndIdx, aData );
  }

  /**
   * @see DataContainer#calculateTime(long)
   */
  public final long calculateTime( final long aTime )
  {
    return this.data.calculateTime( aTime );
  }

  /**
   * @see DataContainer#clearChannelAnnotations(int)
   */
  public final void clearChannelAnnotations( final int aChannelIdx )
  {
    this.data.clearChannelAnnotations( aChannelIdx );
  }

  /**
   * @see DataContainer#getAbsoluteLength()
   */
  @Override
  public final long getAbsoluteLength()
  {
    return this.data.getAbsoluteLength();
  }

  /**
   * @see DataContainer#getChannelLabel(int)
   */
  public final String getChannelLabel( final int aChannelIdx )
  {
    return this.data.getChannelLabel( aChannelIdx );
  }

  /**
   * Returns the channel label for a channel with the given index, using the
   * given default label if the channel's label is not set.
   * 
   * @param aChannelIdx
   *          the index of the channel to return the label for, >= 0 && < 32;
   * @param aDefault
   *          the default label to use in case the channel label is not set.
   * @see DataContainer#getChannelLabel(int)
   */
  public final String getChannelLabel( final int aChannelIdx, final String aDefault )
  {
    String result = this.data.getChannelLabel( aChannelIdx );
    if ( ( result == null ) || result.trim().isEmpty() )
    {
      result = aDefault;
    }
    return result;
  }

  /**
   * @see DataContainer#getChannels()
   */
  @Override
  public final int getChannels()
  {
    return this.data.getChannels();
  }

  /**
   * @see DataContainer#getCursorPosition(int)
   */
  public final long getCursorPosition( final int aCursorIdx ) throws IllegalArgumentException
  {
    return this.data.getCursorPosition( aCursorIdx );
  }

  /**
   * @see DataContainer#getDataAt(long)
   */
  @Override
  public final int getDataAt( final long aAbs )
  {
    return this.data.getDataAt( aAbs );
  }

  /**
   * @see DataContainer#getEnabledChannels()
   */
  @Override
  public final int getEnabledChannels()
  {
    return this.data.getEnabledChannels();
  }

  /**
   * @see DataContainer#getSampleIndex(long)
   */
  @Override
  public final int getSampleIndex( final long aAbs )
  {
    return this.data.getSampleIndex( aAbs );
  }

  /**
   * @see DataContainer#getSampleRate()
   */
  @Override
  public final int getSampleRate()
  {
    return this.data.getSampleRate();
  }

  /**
   * @see DataContainer#getTimestamps()
   */
  @Override
  public final long[] getTimestamps()
  {
    return this.data.getTimestamps();
  }

  /**
   * @see DataContainer#getTriggerPosition()
   */
  @Override
  public final long getTriggerPosition()
  {
    return this.data.getTriggerPosition();
  }

  /**
   * @see DataContainer#getValues()
   */
  @Override
  public final int[] getValues()
  {
    return this.data.getValues();
  }

  /**
   * @see DataContainer#hasCapturedData()
   */
  public final boolean hasCapturedData()
  {
    return this.data.hasCapturedData();
  }

  /**
   * @see DataContainer#hasTimingData()
   */
  @Override
  public final boolean hasTimingData()
  {
    return this.data.hasTimingData();
  }

  /**
   * @see DataContainer#hasTriggerData()
   */
  @Override
  public final boolean hasTriggerData()
  {
    return this.data.hasTriggerData();
  }

  /**
   * @see DataContainer#isChannelLabelSet(int)
   */
  public final boolean isChannelLabelSet( final int aChannelIdx )
  {
    return this.data.isChannelLabelSet( aChannelIdx );
  }

  /**
   * @see DataContainer#isCursorPositionSet(int)
   */
  public final boolean isCursorPositionSet( final int aCursorIdx )
  {
    return this.data.isCursorPositionSet( aCursorIdx );
  }

  /**
   * @see DataContainer#isCursorsEnabled()
   */
  public final boolean isCursorsEnabled()
  {
    return this.data.isCursorsEnabled();
  }

  /**
   * @see DataContainer#setChannelLabel(int, String)
   */
  public final void setChannelLabel( final int aChannelIdx, final String aLabel )
  {
    this.data.setChannelLabel( aChannelIdx, aLabel );
  }

  /**
   * @see DataContainer#setCapturedData(CapturedData)
   */
  protected final void setCapturedData( final CapturedData aCapturedData )
  {
    if ( aCapturedData == this )
    {
      throw new IllegalArgumentException( "Invalid captured data instance!" );
    }
    this.data.setCapturedData( aCapturedData );
  }
}

/* EOF */
